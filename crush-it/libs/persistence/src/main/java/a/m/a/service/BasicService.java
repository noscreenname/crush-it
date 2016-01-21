package a.m.a.service;

import a.m.a.entity.BasicEntity;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BasicService<K extends Serializable, E extends BasicEntity> {

    @Nonnull
    Optional<E> get(@Nonnull K id);

    @Nonnull
    K create(@Nonnull E entity);

    void update(@Nonnull E entity);

    void delete(@Nonnull E entity);

    @Nonnull
    List<E> getAll();
}
