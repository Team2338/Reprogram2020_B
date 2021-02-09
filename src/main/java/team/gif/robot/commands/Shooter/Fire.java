package team.gif.robot.commands.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;
import team.gif.robot.subsystems.Shooter;
//import team.gif.robot.subsystems.indexer;


public class Fire extends CommandBase {
    //TODO Rewrite after indexer is done
    private static final VictorSPX stageFiveMotorVictor  = new VictorSPX(RobotMap.STAGE_FIVE);
    public static final int SENSOR_FIVE = 5;
    private static final DigitalInput stageFiveSensor  = new DigitalInput(SENSOR_FIVE);

    public Fire(boolean useLimeLightVal){
        stageFiveMotorVictor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        double speed = (Robot.oi != null && Robot.oi.dRT.get()) ? Constants.Shooter.RPM_HIGH : Constants.Shooter.RPM_LOW;
        if((Shooter.getInstance().getVelocity() > (speed - 20.0))
            && stageFiveSensor.get())
            //&& (!useLimeLight || ((Math.abs(Robot.limelight.getXOffset()) < Constants.Pivot.marginxF) && Robot.limelight.hasTarget()))) {
        {
            System.out.println("Firing speed: " + Shooter.getInstance().getVelocity());
            stageFiveMotorVictor.set(ControlMode.PercentOutput, .5);
        }
        else {
            stageFiveMotorVictor.set(ControlMode.PercentOutput, 0);
        }

    }

    @Override
    public boolean isFinished(){return false;}

    @Override
    public void end(boolean interrupted){
        stageFiveMotorVictor.set(ControlMode.PercentOutput, 0);
    }
}
