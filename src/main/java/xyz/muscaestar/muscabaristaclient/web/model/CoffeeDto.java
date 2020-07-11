package xyz.muscaestar.muscabaristaclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by muscaestar on 7/9/20
 *
 * @author muscaestar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeDto {
    private UUID id;
    private String cfeName;
    private String cfeStyle;
    private Long upc;
}
