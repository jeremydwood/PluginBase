/**
 * Copyright (c) 2011, The Multiverse Team All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of The Multiverse Team nor the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.dumptruckman.minecraft.pluginbase.messages.messaging;

import com.dumptruckman.minecraft.pluginbase.messages.Message;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

/**
 * Multiverse 2 MessageProvider.
 * <p/>
 * This interface describes a Multiverse-MessageProvider.
 */
public interface MessageProvider {
    /**
     * The default locale.
     */
    @NotNull
    Locale DEFAULT_LOCALE = Locale.ENGLISH;
    @NotNull
    String DEFAULT_LANGUAGE_FILE_NAME = "english.txt";

    /**
     * Returns a message (as {@link String}) for the specified key (as {@link com.dumptruckman.minecraft.pluginbase.messages.Messages}).
     *
     * @param key  The key
     * @param args Args for String.format()
     * @return The message
     */
    @NotNull
    String getMessage(@NotNull Message key, Object... args);

    /**
     * Returns a message (as {@link java.util.List}) of Strings for the specified key (as {@link com.dumptruckman.minecraft.pluginbase.messages.Messages}).
     *
     * @param key  The key
     * @param args Args for String.format()
     * @return The messages
     */
    @Deprecated
    @NotNull
    List<String> getMessages(@NotNull Message key, Object... args);

    /**
     * Returns the Locale this MessageProvider is currently using.
     *
     * @return The locale this MessageProvider is currently using.
     */
    @NotNull
    Locale getLocale();

    /**
     * Sets the locale for this MessageProvider.
     *
     * @param locale The new {@link java.util.Locale}.
     */
    void setLocale(@NotNull Locale locale);

    @Deprecated
    void setLanguage(@NotNull String languageFileName);

    void loadLanguageFile(@NotNull String languageFileName);

    void pruneLanguageFile();
}
