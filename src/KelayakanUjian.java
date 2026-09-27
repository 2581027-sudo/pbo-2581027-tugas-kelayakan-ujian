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
        // Artinya && mengikat lebih kuat daripada ||, jadi Java membaca
        // ekspresi a persis seperti b (bukan seperti c).
        //
        // cek berakhir di 0 karena short-circuit:
        // - pada x, (kehadiran >= 75) sudah false -> && langsung berhenti,
        //   (cek++ >= 0) tidak pernah dijalankan.
        // - pada y, (nilaiTugas >= 60) sudah true -> || langsung berhenti,
        //   (cek++ >= 0) tidak pernah dijalankan.
        // Contoh kombinasi yang MEMBUKTIKAN perbedaan a/b vs c:
        // kehadiran=50, nilaiTugas=90, dispensasi=true
        // -> a=true, b=true, c=false
        // (kehadiran<75 membuat && di kiri false, tapi dispensasi=true menyelamatkan
        // a dan b lewat ||; c tetap false karena && di depan sudah mengunci hasil
        // sebelum sempat melihat dispensasi)
    }
}