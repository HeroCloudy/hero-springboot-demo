package com.yygnb.demo.service.impl;

import com.yygnb.demo.entity.Computer;
import com.yygnb.demo.mapper.ComputerMapper;
import com.yygnb.demo.service.IComputerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电脑 服务实现类
 * </p>
 *
 * @author hero-yyg
 * @since 2022-07-26
 */
@Service
public class ComputerServiceImpl extends ServiceImpl<ComputerMapper, Computer> implements IComputerService {

}
