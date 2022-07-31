package io.github.withlithum.intellimisc;

import io.github.withlithum.intellimisc.block.IntelliMiscBlocks;
import io.github.withlithum.intellimisc.enchant.IntelliMiscEnchants;
import io.github.withlithum.intellimisc.item.IntelliMiscItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Defines the main initialisation type of this modification.
 */
public class IntelliMisc implements ModInitializer {
    @Override
    public void onInitialize() {
        LOGGER.info("Instantiated!");
        IntelliMiscItems.registerItems();
        IntelliMiscBlocks.registerBlocks();
        IntelliMiscBlocks.registerBlockItems();
        IntelliMiscEnchants.registerEnchants();
    }

    public static final Logger LOGGER = LogManager.getLogger("IntelliMisc");

    public static final String NAMESPACE = "intellimisc";

    @Contract("_ -> new")
    public static @NotNull Identifier id(String id) {
        return new Identifier(NAMESPACE, id);
    }
}
