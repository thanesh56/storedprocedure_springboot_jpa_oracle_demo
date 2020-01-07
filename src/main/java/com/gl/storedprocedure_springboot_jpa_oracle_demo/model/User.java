package com.gl.storedprocedure_springboot_jpa_oracle_demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllUsers",
                procedureName = "get_all_users",
                resultClasses = User.class
        ),
        @NamedStoredProcedureQuery(name = "getUserById",
                procedureName = "get_user_by_id",
                parameters =
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "user_id", type = Integer.class),
                resultClasses = User.class


        ),
        @NamedStoredProcedureQuery(
                name = "getNameById",
                procedureName = "get_name_by_id",
                parameters = {
                        @StoredProcedureParameter(name="user_id", mode =ParameterMode.IN,type = Integer.class),
                        @StoredProcedureParameter(name="user_name", mode = ParameterMode.OUT,type = String.class)
                }

        )
})
public class User  implements Serializable {
    @Id
    private int id;
    private String name;
    private String email;
    private String phone;

}
