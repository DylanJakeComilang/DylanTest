package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TankCommand extends CommandBase {
    private DriveSubsystem tankSubsystem;
    private DoubleSupplier leftSpeed;
    private DoubleSupplier rightSpeed;
    
    public TankCommand(DriveSubsystem tankSubsystem, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed){
        this.tankSubsystem = tankSubsystem;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        addRequirements(tankSubsystem);
    }
    
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        double leftSp = leftSpeed.getAsDouble();
        double RightSp = rightSpeed.getAsDouble();

      //  tankSubsystem.setTank(leftSp, RightSp);
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
