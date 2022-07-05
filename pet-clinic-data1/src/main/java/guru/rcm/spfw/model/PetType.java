package guru.rcm.spfw.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

	@Column(name = "name")
	private String name;

}
