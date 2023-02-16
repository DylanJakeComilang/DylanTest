package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeCommand extends CommandBase {
    private DriveSubsystem driveSubsystem; 
    private DoubleSupplier xSpeed;
    private DoubleSupplier zSpeed;
    
    public ArcadeCommand(DriveSubsystem driveSubsystem, DoubleSupplier xSpeed, DoubleSupplier zSpeed){
        this.driveSubsystem = driveSubsystem;
        this.xSpeed = xSpeed;
        this.zSpeed = zSpeed;
        addRequirements(driveSubsystem);
    }
    
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        double leftSp = xSpeed.getAsDouble();
        double RightSp = zSpeed.getAsDouble();

      //  driveSubsystem.setArcade(leftSp, RightSp);
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
