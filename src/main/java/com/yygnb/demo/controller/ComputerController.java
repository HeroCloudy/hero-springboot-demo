package com.yygnb.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yygnb.demo.entity.Computer;
import com.yygnb.demo.service.IComputerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * <p>
 * 电脑 前端控制器
 * </p>
 *
 * @author hero-yyg
 * @since 2022-07-26
 */
@Tag(name = "电脑相关接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/computer")
@Validated
public class ComputerController {

    private final IComputerService computerService;

    @Operation(summary = "根据id查询电脑")
    @GetMapping("/{id}")
    public Computer findById(
            @Parameter(name = "id", required = true, description = "电脑id") @PathVariable Long id) {
        return this.computerService.getById(id);
    }

    @Operation(summary = "分页查询电脑列表")
    @Parameters(value = {
            @Parameter(name = "page", description = "页面，从1开始", example = "2"),
            @Parameter(name = "size", description = "每页大小", example = "10")
    })
    @GetMapping("/find-page/{page}/{size}")
    public Page<Computer> findPage(@PathVariable @Min(1) Integer page, @PathVariable @Max(10) Integer size) {
        return this.computerService.page(new Page<>(page, size));
    }

    @Operation(summary = "新增电脑")
    @PostMapping()
    public Computer save(@RequestBody @Validated Computer computer) {
        computer.setId(null);
        this.computerService.save(computer);
        return computer;
    }

    @Operation(summary = "根据id修改电脑")
    @PutMapping("/{id}")
    public Computer update(
            @Parameter(name = "id", required = true, description = "电脑id") @PathVariable Long id,
            @RequestBody Computer computer) {
        computer.setId(id);
        this.computerService.updateById(computer);
        return computer;
    }

    @Operation(summary = "根据id删除电脑")
    @DeleteMapping("/{id}")
    @Parameter(name = "id", required = true, description = "电脑id")
    public void delete(@PathVariable Long id) {
        this.computerService.removeById(id);
    }
}
