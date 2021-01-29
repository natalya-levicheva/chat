package ru.college.chat.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "fromUserId")
    private User fromUser;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "addresseeId")
    private Addressee addressee;

    private LocalDateTime dateTime;

    private boolean isDeleted;

}
