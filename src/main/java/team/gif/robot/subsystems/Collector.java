package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Collector extends SubsystemBase {

    private static Collector instance = null;

    public static Collector getInstance(){
        if(instance == null) {
            instance = new Collector();
        }
        return instance;
    }
    /**
     * Creates a new ExampleSubsystem.
     */
    private static final VictorSPX intakeMotor= new VictorSPX(RobotMap.INTAKE);

    private static final Solenoid solenoidZero= new Solenoid((RobotMap.INTAKE_SOLENOID_ZERO));
    private static final Solenoid solenoidOne= new Solenoid((RobotMap.INTAKE_SOLENOID_ONE));
    private static final Solenoid solenoidTwo= new Solenoid((RobotMap.INTAKE_SOLENOID_TWO));

    public Collector() {
        super();
        intakeMotor.setInverted(true);
    }
    public void setSpeed(double motorPercent) {
        intakeMotor.set(ControlMode.PercentOutput,motorPercent);
    }

    public void setSolenoids(boolean zero, boolean one, boolean two) {
        solenoidZero.set(zero);
        solenoidOne.set(one);
        solenoidTwo.set(two);
    }
}
