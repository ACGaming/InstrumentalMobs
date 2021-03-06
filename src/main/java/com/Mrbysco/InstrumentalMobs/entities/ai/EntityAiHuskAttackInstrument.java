package com.Mrbysco.InstrumentalMobs.entities.ai;

import com.Mrbysco.InstrumentalMobs.entities.EntityCymbalHusk;

import net.minecraft.util.SoundEvent;

public class EntityAiHuskAttackInstrument extends EntityAIAttackInstrument
{
    private final EntityCymbalHusk zombie;
    private int raiseArmTicks;

    public EntityAiHuskAttackInstrument(EntityCymbalHusk zombieIn, double speedIn, boolean longMemoryIn, SoundEvent sound)
    {
        super(zombieIn, speedIn, longMemoryIn, sound);
        this.zombie = zombieIn;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        super.resetTask();
        this.zombie.setArmsRaised(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        super.updateTask();
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10)
        {
            this.zombie.setClapping(true);
        }
        else
        {
            this.zombie.setClapping(false);
        }
    }
}