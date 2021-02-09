package team.gif.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.subsystems.Shooter;


public class ShooterRun extends CommandBase {

    public ShooterRun(){Robot.limelight.setLEDMode(3);}

    @Override
    public void initialize(){Robot.limelight.setLEDMode(3);}

    @Override
    public void execute(){
        Robot.limelight.setLEDMode(3); // force on
        if(Robot.oi != null && Robot.oi.dRT.get()){
            Shooter.getInstance().setRPM(Constants.Shooter.RPM_HIGH);
        }
        else {
            Shooter.getInstance().setRPM(Constants.Shooter.RPM_LOW);
        }
    }

    @Override
    public boolean isFinished(){return false;}

    @Override
    public void end(boolean interrupted){
        Shooter.getInstance().setVoltage(0); // Stop motor
        Robot.limelight.setLEDMode(1); // force off
    }
}
