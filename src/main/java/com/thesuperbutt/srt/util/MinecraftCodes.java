package com.thesuperbutt.srt.util;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class MinecraftCodes {
    public enum MCColor {
        BLACK("§0", "\\u00A70", "000000"),
        DARK_BLUE("§1", "\\u00A71", "0000AA"),
        DARK_GREEN("§2", "\\u00A72", "00AA00"),
        DARK_AQUA("§3", "\\u00A73", "00AAAA"),
        DARK_RED("§4", "\\u00A74", "AA0000"),
        DARK_PURPLE("§5", "\\u00A75", "AA00AA"),
        GOLD("§6", "\\u00A76", "FFAA00"),
        GRAY("§7", "\\u00A77", "AAAAAA"),
        DARK_GRAY("§8", "\\u00A78", "555555"),
        BLUE("§9", "\\u00A79", "5555FF"),
        GREEN("§a", "\\u00A7a", "55FF55"),
        AQUA("§b", "\\u00A7b", "55FFFF"),
        RED("§c", "\\u00A7c", "FF5555"),
        LIGHT_PURPLE("§d", "\\u00A7d", "FFFF55"),
        YELLOW("§e", "\\u00A7e", "FFFF55"),
        WHITE("§f", "\\u00A7f", "FFFFFF");

        private final String chatCode;
        private final String motdCode;
        private final String hexCode;

        MCColor(String chatCode, String motdCode, String hexCode) {
            this.chatCode = chatCode;
            this.motdCode = motdCode;
            this.hexCode = hexCode;
        }

        public @NotNull String getName() {
            return this.toString().toLowerCase().replace(' ', '_');
        }

        public String getChatCode() {
            return chatCode;
        }

        public String getMotdCode() {
            return motdCode;
        }

        public String getHexCode() {
            return hexCode;
        }

        public @NotNull Color getAsColor() {
            return Color.decode(this.hexCode);
        }
    }

    public enum Format {
        OBFUSCATED("§k", "\\u00A70k"),
        BOLD("§l", "\\u00A70l"),
        STRIKETHROUGH("§m", "\\u00A70m"),
        UNDERLINE("§n", "\\u00A70n"),
        ITALIC("§o", "\\u00A70o"),
        RESET("§r", "\\u00A70r");

        private final String chatCode;
        private final String motdCode;

        Format(String chatCode, String motdCode) {
            this.chatCode = chatCode;
            this.motdCode = motdCode;
        }

        public String getChatCode() {
            return chatCode;
        }

        public String getMotdCode() {
            return motdCode;
        }
    }
}
