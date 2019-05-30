/*
 * Copyright 2019 GridGain Systems, Inc. and Contributors.
 *
 * Licensed under the GridGain Community Edition License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gridgain.com/products/software/community-edition/gridgain-community-edition-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cache.persistence.wal.scanner;

import java.io.File;
import org.apache.ignite.IgniteLogger;
import org.apache.ignite.internal.processors.cache.persistence.file.FileIOFactory;
import org.apache.ignite.internal.processors.cache.persistence.wal.serializer.RecordSerializer;

/**
 * Holder of {@link ScannerHandlers}.
 */
public class ScannerHandlers {
    /** */
    public static final String DEFAULT_WAL_RECORD_PREFIX = "Next WAL record :: ";

    /**
     * @param log Logger.
     * @return Handler which write record to log.
     */
    public static ScannerHandler printToLog(IgniteLogger log) {
        return new PrintToLogHandler(log);
    }

    /**
     * @param file File to write.
     * @return Handler which write record to file.
     */
    public static ScannerHandler printToFile(File file) {
        return new PrintToFileHandler(file, null);
    }

    /**
     * @param file File to write.
     * @param ioFactory IO factory.
     * @return Handler which write record to file.
     */
    public static ScannerHandler printToFile(File file, FileIOFactory ioFactory) {
        return new PrintToFileHandler(file, ioFactory);
    }

    /**
     * @param file File to write.
     * @param serializer WAL records serializer.
     * @return Handler which write record to file.
     */
    public static ScannerHandler printRawToFile(File file, RecordSerializer serializer) {
        return new PrintRawToFileHandler(file, serializer);
    }
}
