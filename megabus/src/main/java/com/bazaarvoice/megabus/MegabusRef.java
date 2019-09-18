package com.bazaarvoice.megabus;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.UUID;
import static java.util.Objects.requireNonNull;


/**
 * Reference to a System of Record update. Designed to be similar to {@link com.bazaarvoice.emodb.sor.core.UpdateRef},
 * but with more flexibility to add new fields without breaking serialization.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MegabusRef {
    private final String _table;
    private final String _key;
    private final UUID _changeId;

    @JsonCreator
    public MegabusRef(@JsonProperty("table") String table, @JsonProperty("key") String key,
                     @JsonProperty("changeId") UUID changeId) {
        _table = requireNonNull(table, "table");
        _key = requireNonNull(key, "key");
        _changeId = requireNonNull(changeId, "changeId");
    }

    public String getTable() {
        return _table;
    }

    public String getKey() {
        return _key;
    }

    public UUID getChangeId() {
        return _changeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MegabusRef)) {
            return false;
        }
        MegabusRef that = (MegabusRef) o;
        return Objects.equal(_table, that._table) &&
                Objects.equal(_key, that._key) &&
                Objects.equal(_changeId, that._changeId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_table, _key, _changeId);
    }

}