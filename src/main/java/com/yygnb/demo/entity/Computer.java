package com.yygnb.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 尺寸
     */
    private BigDecimal size;

    /**
     * 操作系统
     */
    private String operation;

    /**
     * 年份
     */
    private String year;
}
