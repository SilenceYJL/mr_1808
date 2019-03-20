package com.mr.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by yangjiliang on 2019/3/19.
 */
@Data
public class User {

    @Id
    private String userId;

    private String userName;

    private Integer userAge;




}
