package a.m.a.service;

import a.m.a.entity.AttemptEntity;

public final class AttemptService extends BasicServiceImpl<Long, AttemptEntity> {

    public AttemptService() {
        super(AttemptEntity.class);
    }
}
