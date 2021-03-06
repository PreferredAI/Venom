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

package ai.preferred.venom.fetcher;

import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.Response;

import javax.validation.constraints.NotNull;

/**
 * @author Ween Jiann Lee
 */
public interface Callback {

  /**
   * An instance of empty callback.
   */
  Callback EMPTY_CALLBACK = new Callback() {
    @Override
    public void completed(final @NotNull Request request, final @NotNull Response response) {
      // do nothing
    }

    @Override
    public void failed(final @NotNull Request request, final @NotNull Exception ex) {
      // do nothing
    }

    @Override
    public void cancelled(final @NotNull Request request) {
      // do nothing
    }
  };

  /**
   * Method to be call upon completion of request.
   *
   * @param request  Request sent.
   * @param response Response returned.
   */
  void completed(@NotNull Request request, @NotNull Response response);

  /**
   * Method to be call upon failure of request.
   *
   * @param request Request sent.
   * @param ex      Exception received.
   */
  void failed(@NotNull Request request, @NotNull Exception ex);

  /**
   * Method to be call upon cancellation of request.
   *
   * @param request Request sent.
   */
  void cancelled(@NotNull Request request);

}
