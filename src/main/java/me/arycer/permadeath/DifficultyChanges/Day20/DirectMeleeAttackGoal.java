package me.arycer.permadeath.DifficultyChanges.Day20;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

import java.util.EnumSet;

public class DirectMeleeAttackGoal extends Goal {

    private final PathAwareEntity mob;
    private final double speed;
    private int attackCooldown;

    public DirectMeleeAttackGoal(PathAwareEntity mob, double speed) {
        this.mob = mob;
        this.speed = speed;

        this.setControls(EnumSet.of(
                Goal.Control.MOVE,
                Goal.Control.LOOK
        ));
    }

    @Override
    public boolean canStart() {
        LivingEntity target = mob.getTarget();

        return target instanceof PlayerEntity
                && target.isAlive()
                && !target.isSpectator();
    }

    @Override
    public boolean shouldContinue() {
        LivingEntity target = mob.getTarget();

        return target instanceof PlayerEntity
                && target.isAlive()
                && !target.isSpectator();
    }

    @Override
    public void start() {
        attackCooldown = 0;
    }

    @Override
    public void stop() {
        mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();

        if (!(target instanceof PlayerEntity) || !target.isAlive()) {
            return;
        }

        mob.getLookControl().lookAt(target, 30.0F, 30.0F);

        mob.getNavigation().startMovingTo(target, speed);

        if (attackCooldown > 0) {
            attackCooldown--;
        }

        if (mob.squaredDistanceTo(target) <= 4.0
                && attackCooldown <= 0) {

            mob.swingHand(Hand.MAIN_HAND);

            target.damage(
                    mob.getWorld().getDamageSources().mobAttack(mob),
                    8.0F
            );

            attackCooldown = 20;
        }
    }
}
