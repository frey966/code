package com.bfw.common.utils.code;

public class SnowflakeIdWorker {
    private final long sequenceIdBits = 12L;
    private final long sequenceIdMask = 4095L;
    private long sequencedId = 0L;
    private final long workIdBits = 5L;
    private final long maxWorkId = 31L;
    private long workId;
    private final long datacenterIdBits = 5L;
    private final long maxDataCenterId = 31L;
    private long datacenterId;
    private final long workIdShift = 12L;
    private final long datacenterIdShift = 17L;
    private final long twepoch = 1545126625220L;
    private Long lastTimestamp = -1L;
    private long timestampShift;

    public SnowflakeIdWorker(long workId, long datacenterId) {
        this.timestampShift = 17L + this.datacenterId;
        if (workId > 31L | workId < 0L) {
            throw new IllegalArgumentException("wordId必须在[0,31]之间");
        } else if (datacenterId > 31L | datacenterId < 0L) {
            throw new IllegalArgumentException("datacenterId[0,31]之间");
        } else {
            this.workId = workId;
            this.datacenterId = datacenterId;
        }
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

        if (timestamp == this.lastTimestamp) {
            this.sequencedId = this.sequencedId + 1L & 4095L;
            if (this.sequencedId == 0L) {
                while(timestamp <= this.lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            this.sequencedId = 0L;
        }

        this.lastTimestamp = timestamp;
        return timestamp - 1545126625220L << (int)this.timestampShift | this.datacenterId << 17 | this.workId << 12 | this.sequencedId;
    }
}
