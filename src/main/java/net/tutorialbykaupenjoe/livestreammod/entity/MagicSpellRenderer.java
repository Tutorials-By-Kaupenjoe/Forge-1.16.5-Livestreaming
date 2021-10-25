package net.tutorialbykaupenjoe.livestreammod.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.MinecartModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.tutorialbykaupenjoe.livestreammod.LivestreamMod;
import net.tutorialbykaupenjoe.livestreammod.entity.projectile.MagicSpellEntity;

public class MagicSpellRenderer<T extends MagicSpellEntity> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LivestreamMod.MOD_ID, "textures/entity/magicspell.png");
    protected final EntityModel<T> modelMagicSpell = new MagicSpellModel<>();

    public MagicSpellRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
                       IRenderTypeBuffer bufferIn, int packedLightIn) {

        IVertexBuilder ivertexbuilder =
                bufferIn.getBuffer(this.modelMagicSpell.getRenderType(this.getEntityTexture(entityIn)));
        modelMagicSpell.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return TEXTURE;
    }
}
