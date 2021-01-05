package com.zzs.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mountain
 * @since 2020/12/7 23:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * 支付id
     */
    private Long id;
    /**
     * 支付编号
     */
    private String serial;
}
