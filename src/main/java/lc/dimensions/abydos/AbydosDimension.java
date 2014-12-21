package lc.dimensions.abydos;

import lc.ResourceAccess;
import lc.api.defs.IDefinitionReference;
import lc.api.defs.IDimensionDefinition;
import lc.common.impl.registry.DefinitionReference;
import lc.generation.AbydosPyramid;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

/**
 * Abydos dimension implementation
 *
 * @author AfterLifeLochie
 *
 */
public class AbydosDimension implements IDimensionDefinition {

	/**
	 * Default constructor
	 *
	 * @param providerId
	 *            The provider ID to use
	 * @param dimensionId
	 *            The dimension ID to use
	 */
	public AbydosDimension(final int providerId, final int dimensionId) {
		DimensionManager.registerProviderType(providerId, getWorldProviderClass(), false);
		DimensionManager.registerDimension(dimensionId, providerId);
		MapGenStructureIO.func_143031_a(AbydosPyramid.class,
				ResourceAccess.formatResourceName("${ASSET_KEY}:AbydosPyramid"));
	}

	@Override
	public Class<? extends WorldProvider> getWorldProviderClass() {
		return AbydosWorldProvider.class;
	}

	@Override
	public IDefinitionReference ref() {
		return new DefinitionReference(this);
	}

}
