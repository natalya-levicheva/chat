package ru.college.chat.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Addressee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addresseeId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "toUserId")
    private User toUser;

    @OneToMany(mappedBy = "addressee",fetch = FetchType.EAGER)
    private List<Message> messages;

    private boolean isRead;
}
