package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmCommand extends CommandBase {
    /* 
    ArmSubsystem arm;
    double speed;
    int iCount;

    public ArmCommand(ArmSubsystem arm, double speed) {
        this.speed = speed;
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("Arm State", "Starting");
        iCount = 0;
        arm.resetEncoder();
    }

    @Override
    public void execute() {
        SmartDashboard.putString("Arm State", "Executing");
        SmartDashboard.putNumber("iCount", iCount);
        SmartDashboard.putNumber("Arm Encoder", arm.getEncoder());

        /*
         * iswitch (iCount) {
         * case 0:
         * f(arm.getEncoder() >= 50){
         * arm.setStop();
         * iCount++;
         * }
         * else{
         * arm.setForwards();
         * }
         * break;
         * case 1:
         * if(arm.getEncoder() <= 0){
         * arm.setStop();
         * iCount++;
         * }
         * else{
         * arm.setBackwards();
         * }
         * break;
         * case 2:
         * if(arm.getEncoder() >= 50){
         * arm.setStop();
         * iCount++;
         * }
         * else{
         * arm.setForwards();
         * }
         * }
         
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putString("Arm State", "Ending");
        iCount = 0;
        arm.resetEncoder();
    }

    @Override
    public boolean isFinished() {
        return iCount >= 3;
    }
*/
}
