package com.yygnb.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yygnb.demo.entity.Computer;
import com.yygnb.demo.service.IComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 电脑 前端控制器
 * </p>
 *
 * @author hero-yyg
 * @since 2022-07-26
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/computer")
public class ComputerController {

    private final IComputerService computerService;

    @GetMapping("/{id}")
    public Computer findById(@PathVariable Long id) {
        return this.computerService.getById(id);
    }

    @GetMapping("/find-page/{page}/{size}")
    public Page<Computer> findPage(@PathVariable Integer page, @PathVariable Integer size) {
        return this.computerService.page(new Page<>(page, size));
    }

    @PostMapping()
    public Computer save(@RequestBody Computer computer) {
        computer.setId(null);
        this.computerService.save(computer);
        return computer;
    }

    @PutMapping("/{id}")
    public Computer update(@PathVariable Long id, @RequestBody Computer computer) {
        computer.setId(id);
        this.computerService.updateById(computer);
        return computer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.computerService.removeById(id);
    }
}
