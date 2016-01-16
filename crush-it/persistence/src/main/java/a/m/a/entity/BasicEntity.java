package a.m.a.entity;

import javax.annotation.Nullable;
import java.io.Serializable;

public interface BasicEntity<K extends Serializable> {

    @Nullable
    K getId();
}
