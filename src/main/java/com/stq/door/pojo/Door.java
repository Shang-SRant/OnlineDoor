package com.stq.door.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Shang_SRant
 * @since 2020-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Door implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;

    private String dname;

    private String dstate;

    private Date dinstall;

    private Date dtime;


}
