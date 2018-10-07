package ch.rest.client;

import ch.basebeans.entity.Singer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
 * Wrapper for retrieving a list of Singer instances
 */
@Getter
@Setter
public class Singers {
    private List<Singer> singers;

    public Singers() {
        singers = new ArrayList<>();
    }
}
