/*
 * Copyright (c) 2015 Spotify AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.spotify.folsom.transcoder;

import com.spotify.folsom.Transcoder;
import java.io.Serializable;
import org.apache.commons.lang.SerializationUtils;

public final class SerializableObjectTranscoder<T extends Serializable> implements Transcoder<T> {

  public static final SerializableObjectTranscoder INSTANCE = new SerializableObjectTranscoder<>();

  public static <T extends Serializable> SerializableObjectTranscoder<T> getInstance() {
    return INSTANCE;
  }

  private SerializableObjectTranscoder() {}

  @Override
  public byte[] encode(final Serializable t) {
    return SerializationUtils.serialize(t);
  }

  @Override
  public T decode(final byte[] b) {
    return (T) SerializationUtils.deserialize(b);
  }
}
