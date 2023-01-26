package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmUpCommand extends CommandBase {
    ArmSubsystem arm;
    double speed;
    int iCount;

    public ArmUpCommand(ArmSubsystem arm, double speed) {
        this.speed = speed;
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("Arm State", "Starting");
        iCount = 0;
    }

    @Override
    public void execute() {
        SmartDashboard.putString("Arm State", "Executing");
        SmartDashboard.putNumber("iCount", iCount);
        SmartDashboard.putNumber("Arm Encoder", arm.getEncoder());

        if (arm.getEncoder() >= 26) {
            arm.setStop();
        }
        else{
            arm.setSpeed(speed);
        }

        
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Arm State", "Ending");
        arm.setStop();
        iCount = 0;
    }

    @Override
    public boolean isFinished() {
        return iCount >= 3;
    }

}
