package com.example.app.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "role_account")
public class RoleAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

}
