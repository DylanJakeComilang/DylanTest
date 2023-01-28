package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


public class ClawSubsystem extends SubsystemBase {
    private final Compressor comp = new Compressor(null);
    private final DoubleSolenoid solenoid;
    
    private ClawSubsystem(){
        this.solenoid = new DoubleSolenoid(null, 0, 0);
    }
    
     public void setOpen(){
        solenoid.set(DoubleSolenoid.Value.kForward);
    }
     public void setClose(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    @Override
    public void periodic() {

    }
}
