package domainapp.modules.simple.cognitiva;

import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;

import javax.jdo.annotations.Column;

@Getter
@Setter
@lombok.RequiredArgsConstructor
public class Cognitiva {

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String comerSolo;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String bañoSolo;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String vestirSolo;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String bañarseSolo;

    @lombok.NonNull
    @Column(allowsNull = "false", length = 40)
    @Property()
    @Title()
    private String moverSolo;
}
