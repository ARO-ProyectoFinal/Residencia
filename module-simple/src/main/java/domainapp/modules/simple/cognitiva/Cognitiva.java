package domainapp.modules.simple.cognitiva;

import domainapp.modules.simple.historia.Selector;
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
    @Column(allowsNull = "false")
    @Property()
    @Title()
    private Selector comerSolo;

    @lombok.NonNull
    @Column(allowsNull = "false")
    @Property()
    @Title()
    private Selector bañoSolo;

    @lombok.NonNull
    @Column(allowsNull = "false")
    @Property()
    @Title()
    private Selector vestirSolo;

    @lombok.NonNull
    @Column(allowsNull = "false")
    @Property()
    @Title()
    private Selector bañarseSolo;

    @lombok.NonNull
    @Column(allowsNull = "false")
    @Property()
    @Title()
    private Selector moverSolo;
}
