package com.yygnb.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 电脑
 * </p>
 *
 * @author hero-yyg
 * @since 2022-07-26
 */
@Schema(title = "电脑")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(title = "尺寸")
    private BigDecimal size;

    @Schema(title = "操作系统")
    private String operation;

    @Schema(title = "年份")
    private String year;
}
