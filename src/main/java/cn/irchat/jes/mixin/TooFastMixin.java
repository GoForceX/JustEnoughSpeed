package cn.irchat.jes.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerGamePacketListenerImpl.class)
public class TooFastMixin {
    @ModifyConstant(method = "handleMoveVehicle", constant = @Constant(doubleValue = 100.0D))
    private double handleMoveVehicleSpeedModify(double speed) {
        return Double.MAX_VALUE;
    }

    @ModifyConstant(method = "handleMovePlayer", constant = @Constant(floatValue = 100.0F))
    private float handleMovePlayerSpeedModifyNormal(float speed) {
        return Float.MAX_VALUE;
    }

    @ModifyConstant(method = "handleMovePlayer", constant = @Constant(floatValue = 300.0F))
    private float handleMovePlayerSpeedModifyFall(float speed) {
        return Float.MAX_VALUE;
    }
}
