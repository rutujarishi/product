package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


/*Each entity must have at least two annotations defined: @Entity and @Id.
The @Entity annotation specifies that the class is an entity and is mapped to a database table.
The @Table annotation specifies the name of the database table to be used for mapping.
The @Id annotation specifies the primary key of an entity and the
@GeneratedValue provides for the specification of generation strategies for the values of primary keys.*/


@Entity
@Table(name = "usercreds")
public class DAOUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
