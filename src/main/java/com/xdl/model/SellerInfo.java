package com.xdl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 买家
 *
 * @author xdl
 * @date 2018-08-18
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
