package fiap.com.br.SofiaBag.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import javax.persistence.*;

@Entity(name = "OBJETO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Object {

    @Id
    @Column(name = "cd_rfid", unique = true)
    private String cdRfid;

    @Column(name = "nm_objeto", nullable = false)
    private String name;

    @Column(name = "cat_objeto")
    private String category;

    @Column(name = "in_backpack")
    private boolean inBackpack;

    @JsonIgnore
    @OneToMany(mappedBy = "object", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Reminder> reminders; 
    
    @ManyToOne
    @JoinColumn
    private User user;

}
