package ch.rest.serialization;

import ch.basebeans.entity.Singer;

import java.io.Serializable;
import java.util.List;

/*
 * To serialize and deserialize a List of singers,
 * it needs to be encapsulates in a container.
 *
 * Required for XML serialization; JSON works without a container class
 */
public class Singers implements Serializable {
    private List<Singer> singers;

    public Singers() {
    }

    public Singers(final List<Singer> singers) {
        this.singers = singers;
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(final List<Singer> singers) {
        this.singers = singers;
    }
}
