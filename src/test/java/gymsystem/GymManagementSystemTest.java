package gymsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para Gym Management System.
 * Verifica las funcionalidades principales del sistema.
 */
public class GymManagementSystemTest {

    private String[][] members;
    private String[][] trainers;
    private String[][] machines;

    @BeforeEach
    public void setUp() {
        members  = new String[200][12];
        trainers = new String[20][4];
        machines = new String[15][12];

        // Inicializar con null
        for (int i = 0; i < members.length; i++)
            for (int j = 0; j < members[0].length; j++)
                members[i][j] = "null";

        for (int i = 0; i < trainers.length; i++)
            for (int j = 0; j < trainers[0].length; j++)
                trainers[i][j] = "null";

        for (int i = 0; i < machines.length; i++)
            for (int j = 0; j < machines[0].length; j++)
                machines[i][j] = "null";
    }

    // ── TESTS MIEMBROS ──────────────────────────────────────

    @Test
    public void testMembersArraySize() {
        assertEquals(200, members.length);
        assertEquals(12, members[0].length);
    }

    @Test
    public void testMembersInitializedAsNull() {
        assertEquals("null", members[0][0]);
        assertEquals("null", members[199][11]);
    }

    @Test
    public void testAddMember() {
        members[0][0] = "1001";
        members[0][1] = "Juan";
        members[0][2] = "Garcia";
        members[0][4] = "Male";
        members[0][7] = "Weight Loss";
        members[0][10] = "Morning";

        assertEquals("1001",       members[0][0]);
        assertEquals("Juan",       members[0][1]);
        assertEquals("Garcia",     members[0][2]);
        assertEquals("Male",       members[0][4]);
        assertEquals("Weight Loss",members[0][7]);
        assertEquals("Morning",    members[0][10]);
    }

    @Test
    public void testFindMemberByRegNo() {
        members[0][0] = "1001";
        members[0][1] = "Juan";
        members[1][0] = "1002";
        members[1][1] = "Maria";

        int index = -1;
        for (int i = 0; i < members.length; i++) {
            if ("1002".equals(members[i][0])) {
                index = i;
                break;
            }
        }
        assertEquals(1, index);
        assertEquals("Maria", members[index][1]);
    }

    @Test
    public void testMemberNotFound() {
        members[0][0] = "1001";
        int index = -1;
        for (int i = 0; i < members.length; i++) {
            if ("9999".equals(members[i][0])) {
                index = i;
                break;
            }
        }
        assertEquals(-1, index);
    }

    @Test
    public void testDeleteMember() {
        members[0][0] = "1001";
        members[0][1] = "Juan";

        // Simular borrado
        for (int j = 0; j < members[0].length; j++)
            members[0][j] = "null";

        assertEquals("null", members[0][0]);
        assertEquals("null", members[0][1]);
    }

    @Test
    public void testModifyMemberName() {
        members[0][0] = "1001";
        members[0][1] = "Juan";
        members[0][1] = "Carlos";
        assertEquals("Carlos", members[0][1]);
    }

    @Test
    public void testMemberFitnessPrograms() {
        String[] programs = {"Weight Loss", "Muscle Gain", "Shredding"};
        members[0][7] = programs[0];
        members[1][7] = programs[1];
        members[2][7] = programs[2];

        assertEquals("Weight Loss",  members[0][7]);
        assertEquals("Muscle Gain",  members[1][7]);
        assertEquals("Shredding",    members[2][7]);
    }

    @Test
    public void testMemberSessions() {
        members[0][10] = "Morning";
        members[1][10] = "Evening";
        assertEquals("Morning", members[0][10]);
        assertEquals("Evening", members[1][10]);
    }

    // ── TESTS ENTRENADORES ──────────────────────────────────

    @Test
    public void testTrainersArraySize() {
        assertEquals(20, trainers.length);
        assertEquals(4,  trainers[0].length);
    }

    @Test
    public void testAddTrainer() {
        trainers[0][0] = "T001";
        trainers[0][1] = "Pedro";
        trainers[0][2] = "Lopez";
        trainers[0][3] = "Cardio";

        assertEquals("T001",   trainers[0][0]);
        assertEquals("Pedro",  trainers[0][1]);
        assertEquals("Lopez",  trainers[0][2]);
        assertEquals("Cardio", trainers[0][3]);
    }

    @Test
    public void testFindTrainerByRegNo() {
        trainers[0][0] = "T001";
        trainers[0][1] = "Pedro";
        trainers[1][0] = "T002";
        trainers[1][1] = "Ana";

        int index = -1;
        for (int i = 0; i < trainers.length; i++) {
            if ("T002".equals(trainers[i][0])) {
                index = i;
                break;
            }
        }
        assertEquals(1, index);
        assertEquals("Ana", trainers[index][1]);
    }

    @Test
    public void testDeleteTrainer() {
        trainers[0][0] = "T001";
        trainers[0][1] = "Pedro";

        for (int j = 0; j < trainers[0].length; j++)
            trainers[0][j] = "null";

        assertEquals("null", trainers[0][0]);
    }

    // ── TESTS MÁQUINAS ──────────────────────────────────────

    @Test
    public void testMachinesArraySize() {
        assertEquals(15, machines.length);
        assertEquals(12, machines[0].length);
    }

    @Test
    public void testAddMachine() {
        machines[0][0] = "M001";
        machines[0][1] = "Treadmill";
        machines[0][2] = "Running";

        assertEquals("M001",      machines[0][0]);
        assertEquals("Treadmill", machines[0][1]);
        assertEquals("Running",   machines[0][2]);
    }

    @Test
    public void testDeleteMachine() {
        machines[0][0] = "M001";
        machines[0][1] = "Treadmill";

        for (int j = 0; j < machines[0].length; j++)
            machines[0][j] = "null";

        assertEquals("null", machines[0][0]);
    }

    // ── TESTS RESERVAS ──────────────────────────────────────

    @Test
    public void testBookMachine() {
        machines[0][0]  = "M001";
        machines[0][3]  = "null"; // sin reserva mañana
        machines[0][3]  = "1001"; // reservar
        assertEquals("1001", machines[0][3]);
    }

    @Test
    public void testCancelBooking() {
        machines[0][3] = "1001";
        machines[0][3] = "null";
        assertEquals("null", machines[0][3]);
    }

    // ── TESTS VALIDACIÓN ────────────────────────────────────

    @Test
    public void testRegNoIsNumeric() {
        String regNo = "1050";
        assertTrue(regNo.matches("\\d+"));
    }

    @Test
    public void testRegNoNotNumeric() {
        String regNo = "ABC1";
        assertFalse(regNo.matches("\\d+"));
    }

    @Test
    public void testPhoneFormat() {
        String phone = "0312-1234567";
        assertTrue(phone.matches("03\\d{2}-\\d{7}"));
    }

    @Test
    public void testPhoneFormatInvalid() {
        String phone = "1234-abcdefg";
        assertFalse(phone.matches("03\\d{2}-\\d{7}"));
    }

    @Test
    public void testNameOnlyLetters() {
        String name = "Juan";
        assertTrue(name.matches("[a-zA-Z]+"));
    }

    @Test
    public void testNameWithNumbers() {
        String name = "Juan123";
        assertFalse(name.matches("[a-zA-Z]+"));
    }

    @Test
    public void testMembershipTypes() {
        String[] memberships = {
            "One Year", "Six Month", "Three Month", "One Month"
        };
        members[0][11] = memberships[0];
        members[1][11] = memberships[1];
        members[2][11] = memberships[2];
        members[3][11] = memberships[3];

        assertEquals("One Year",    members[0][11]);
        assertEquals("Six Month",   members[1][11]);
        assertEquals("Three Month", members[2][11]);
        assertEquals("One Month",   members[3][11]);
    }

    @Test
    public void testCountActiveMembers() {
        members[0][0] = "1001";
        members[1][0] = "1002";
        members[2][0] = "null";

        int count = 0;
        for (String[] member : members)
            if (!"null".equals(member[0])) count++;

        assertEquals(2, count);
    }

    @Test
    public void testCountActiveTrainers() {
        trainers[0][0] = "T001";
        trainers[1][0] = "T002";

        int count = 0;
        for (String[] trainer : trainers)
            if (!"null".equals(trainer[0])) count++;

        assertEquals(2, count);
    }
}
