import java.util.Scanner;

public class KelayakanUjian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kehadiran (%)            : ");
        int kehadiran = scanner.nextInt();

        System.out.print("Nilai tugas              : ");
        int nilaiTugas = scanner.nextInt();

        System.out.print("Dispensasi (true/false)  : ");
        boolean dispensasi = scanner.nextBoolean();

        // Tiga versi penulisan syarat kelayakan
        boolean a = kehadiran >= 75 && nilaiTugas >= 60 || dispensasi;
        boolean b = (kehadiran >= 75 && nilaiTugas >= 60) || dispensasi;
        boolean c = kehadiran >= 75 && (nilaiTugas >= 60 || dispensasi);
        boolean notDispensasi = !dispensasi;

        // Bukti short-circuit
        int cek = 0;
        boolean x = (kehadiran >= 75) && (cek++ >= 0);
        boolean y = (nilaiTugas >= 60) || (cek++ >= 0);

        System.out.println();
        System.out.println("===== KELAYAKAN UJIAN =====");
        System.out.println("Kehadiran   : " + kehadiran + "%");
        System.out.println("Nilai tugas : " + nilaiTugas);
        System.out.println("Dispensasi  : " + dispensasi);
        System.out.println();
        System.out.println("a (tanpa kurung)      : " + a);
        System.out.println("b (kurung precedence) : " + b);
        System.out.println("c (kurung digeser)    : " + c);
        System.out.println("!dispensasi           : " + notDispensasi);
        System.out.println("cek dipanggil         : " + cek);
        // KESIMPULAN:
// a selalu sama dengan b, belum tentu sama dengan c.
// && mengikat lebih kuat daripada ||, jadi Java membaca ekspresi a
// persis seperti b (bukan seperti c).
// Perbedaan a/b vs c hanya muncul saat kehadiran < 75 (membuat && di kiri
// false) DAN dispensasi true: a/b jadi true (tertolong || dispensasi),
// tapi c tetap false karena && di depan sudah mengunci hasil.
// Kombinasi lain (mis. kehadiran 80, nilai tugas 55) tidak memperlihatkan
// beda ini karena tidak memenuhi syarat tersebut.
//
// cek berakhir di 0 karena short-circuit:
// - pada x, (kehadiran >= 75) sudah false -> && langsung berhenti,
//   (cek++ >= 0) tidak pernah dijalankan.
// - pada y, (nilaiTugas >= 60) sudah true -> || langsung berhenti,
//   (cek++ >= 0) tidak pernah dijalankan.c

    }
}