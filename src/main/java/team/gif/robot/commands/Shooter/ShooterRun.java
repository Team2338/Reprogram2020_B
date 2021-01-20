package team.gif.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.subsystems.Shooter;


public class ShooterRun extends CommandBase {

    public ShooterRun(){}

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        Shooter.getInstance().setVoltage(0.2);
    }

    @Override
    public boolean isFinished(){return false;}

    @Override
    public void end(boolean interrupted){
        Shooter.getInstance().setVoltage(0);
    }
}
