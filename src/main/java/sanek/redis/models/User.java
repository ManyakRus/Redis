/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.redis.models;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Sanek
 */
@Data
public class User  implements Serializable{
    @Id
    private String id = "";
    private String name;
    private Integer salary;
    
    
}
