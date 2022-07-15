#Author: intanjuniar101@gmail.com
Feature: Add Pengajuan Promotion Jabatan

  Scenario Outline: Add data Promosi jabatan dengan *fiel_nik*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih nik <nik>
    And User memilih tglEf <tglEf>, status <status>, unit <unit>, perubahan jabatan <jabatan>, divisi <divisi>, level <level>
    And User mengisi penilaian <opt01>,<opt02>,<opt03>,<opt04>,<opt05>,<opt06>,<opt07>,<opt08>,<opt09>,<opt10>
    And User mengisi aspek Kelebihan <kelebihan>
    And User mengisi aspek yang perlu ditingkat <grow>
    And User mengisi asuransi <asuransi>
    And User memilih ulasan atasan <ulasan>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *fiel_nik* dipilih ---no nik--
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih nik <nik>
    And User memilih tglEf <tglEf>, status <status>, unit <unit>, perubahan jabatan <jabatan>, divisi <divisi>, level <level>
    And User mengisi penilaian <opt01>,<opt02>,<opt03>,<opt04>,<opt05>,<opt06>,<opt07>,<opt08>,<opt09>,<opt10>
    And User mengisi aspek Kelebihan <kelebihan>
    And User mengisi aspek yang perlu ditingkat <grow>
    And User mengisi asuransi <asuransi>
    And User memilih ulasan atasan <ulasan>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field nik kosong

    Examples: 
      | nik         | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin         | tgl        | note  |
      | -- Pilih -- | 2022-07-20 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin Booster | 2022-04-12 | sdasf |

  @tag2
  Scenario Outline: cek setiap *field* pada add data Promosi jabatan
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih nik <nik>
    And User memilih tglEf <tglEf>, status <status>, unit <unit>, perubahan jabatan <jabatan>, divisi <divisi>, level <level>
    And User mengisi penilaian <opt01>,<opt02>,<opt03>,<opt04>,<opt05>,<opt06>,<opt07>,<opt08>,<opt09>,<opt10>
    And User mengisi aspek Kelebihan <kelebihan>
    And User mengisi aspek yang perlu ditingkat <grow>
    And User mengisi asuransi <asuransi>
    And User memilih ulasan atasan <ulasan>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | tglEf      | status | unit                   | jabatan | divisi               | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan                | grow                   | asuransi | ulasan               | vaksin           | tgl        | note                 |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura           | ASM     | Operational          | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS TK  | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | OKE                  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | PKWTT  | Smart Cash             | BSH     | Management           | GM    |     5 |     4 |     7 |     5 |     4 |     3 |     6 |     4 |     4 |     4 | Kerja keras              | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 1         | 2021-04-12 | Baik                 |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-12 | MITRA  | Personal Loan          | ASM     | Operational          | RSM   |     6 |     5 |     6 |     5 |     4 |     5 |     4 |     5 |     4 |     4 | Disiplin                 | Terus Belajar          | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | Perbarui sertifikasi |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-12 | PKWT   | Recruitment            | ASM     | BOOTCAM              | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Jujur                    | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin Booster   | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | PKWT   | Angkasa Pura           | RSM     | Operational          | ASM   |     4 |     4 |     7 |     5 |     4 |     3 |     5 |     6 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 1         | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-19 | PKWTT  | Sales Governance Unit  | SM      | BOOTCAM              | ASM   |     6 |     6 |     7 |     5 |     4 |     4 |     4 |     4 |     4 |     4 | Disiplin                 | Tingkatkan kreativitas | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-19 | MAGANG | Angkasa Pura           | SPV     | Operational          | RSM   |     6 |     4 |     5 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Bertanggung Jawab        | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin Booster   | 2022-04-12 | Ambil course         |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | MITRA  | Angkasa Pura           | SPB     | Management           | ASM   |     5 |     4 |     7 |     5 |     4 |     6 |     7 |     5 |     4 |     4 | Disiplin                 | Time management        | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | PKWT   | MIS Pura               | ASM     | Operational          | GM    |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Inovatif                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Penyintas        | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-12 | PKWT   | Angkasa Pura           | DSR     | Sales and Marketing  | ASM   |     6 |     6 |     7 |     5 |     4 |     3 |     4 |     5 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | Pelajari ML          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-21 | MITRA  | Business Development   | ASM     | Operational          | ASM   |     7 |     4 |     4 |     5 |     4 |     7 |     3 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin Booster   | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | MITRA  | Angkasa Pura           | RM      | BOOTCAM              | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-13 | PKWTT  | Angkasa Pura           | TM      | Operational          | SM    |     5 |     4 |     7 |     5 |     4 |     3 |     4 |     7 |     4 |     4 | Time managementnya bagus | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-14 | PKWT   | Application Processing | ASM     | Operational          | ASM   |     6 |     2 |     5 |     5 |     4 |     4 |     4 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 1         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWTT  | Angkasa Pura           | FP      | BOOTCAM              | RSM   |     4 |     4 |     7 |     5 |     4 |     3 |     6 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-09 | PKWT   | Sales Governance Unit  | TM      | Business Development | ASM   |     6 |     7 |     7 |     5 |     4 |     3 |     4 |     6 |     4 |     4 | Lead terbaik             | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-14 | MAGANG | Angkasa Pura           | ASM     | Operational          | ASM   |     5 |     4 |     6 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Penyintas        | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | PKWT   | Angkasa Pura           | RO      | Event Organizer      | GM    |     6 |     4 |     7 |     5 |     4 |     5 |     4 |     5 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin Booster   | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-17 | PKWT   | Business Development   | SPG     | Operational          | RSM   |     6 |     4 |     7 |     5 |     4 |     3 |     5 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | MAGANG | Angkasa Pura           | ASM     | Sales and Marketing  | ASM   |     6 |     5 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin Booster   | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Application Processing | TS      | Operational          | ASM   |     6 |     4 |     7 |     5 |     4 |     6 |     4 |     3 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-11 | MAGANG | Angkasa Pura           | ASM     | Sales and Marketing  | ASM   |     6 |     5 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin Booster   | 2022-04-12 | sdasf                |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Application Processing | TS      | Operational          | ASM   |     6 |     4 |     7 |     5 |     4 |     6 |     4 |     3 |     4 |     4 | Disiplin                 | Fokus                  | BPJS K   | Lulus Masa Percobaan | Vaksin 2         | 2022-01-12 | sdasf                |
