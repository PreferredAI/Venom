/*
 * Copyright 2018 Preferred.AI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ai.preferred.venom.response;

import ai.preferred.venom.storage.Record;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;

import javax.validation.constraints.NotNull;


/**
 * @author Ween Jiann Lee
 */
public class StorageResponse implements Response, Retrievable {

  /**
   * The record holding this response.
   */
  private final Record<?> record;

  /**
   * The url of this response.
   */
  private final String url;

  /**
   * Constructs a base response.
   *
   * @param record record holding this response
   * @param url    base URL of the response
   */
  public StorageResponse(final Record<?> record, final String url) {
    this.record = record;
    this.url = url;
  }

  @Override
  public final int getStatusCode() {
    return record.getStatusCode();
  }

  @Override
  public final byte[] getContent() {
    return record.getResponseContent();
  }

  @Override
  public final @NotNull ContentType getContentType() {
    return record.getContentType();
  }

  @Override
  public final @NotNull Header[] getHeaders() {
    return record.getResponseHeaders();
  }

  @Override
  public final @NotNull String getUrl() {
    return url;
  }

  @Override
  public final @NotNull String getBaseUrl() {
    return getUrl();
  }

  @Override
  public final HttpHost getProxy() {
    return null;
  }

  @Override
  public final Record<?> getRecord() {
    return record;
  }
}
