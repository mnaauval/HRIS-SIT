#Author: intanjuniar101@gmail.com
Feature: Add Pengajuan Promotion Jabatan

  @tag
  Scenario Outline: Add data Promosi jabatan dengan *field_NIK* tidak dipilih
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih status <status>, unit <unit>, perubahan jabatan <jabatan>, divisi <divisi>, level <level>
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
      | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | 2022-07-21 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *field_tglEf* Kosong
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih nik <nik>
    And User memilih status <status>, unit <unit>, perubahan jabatan <jabatan>, divisi <divisi>, level <level>
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
    And Validasi field tglEf kosong

    Examples: 
      | nik                              | tglEf | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W |       | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *field_Status* Kosong
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
    And Validasi field status kosong

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 |        | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS TK  | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | OKE  |

  Scenario Outline: Add data Promosi jabatan dengan *field_Unit* Kosong
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
    And Validasi field unit kosong

    Examples: 
      | nik                              | tglEf      | status | unit | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   |      | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *field_Jabatan* Kosong
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
    And Validasi field jabatan kosong

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura |         | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *field_divisi* Kosong
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
    And Validasi field divisi kosong

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     |        | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *field_level* Kosong
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
    And Validasi field level kosong

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational |       |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

Scenario Outline: Add data Perubahan salary *variasiData_Gapok*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan salary
    And User memilih nik <nik>
    And User mengisi gapok <gapok>, jabatan <jabatan>, komunikasi <komunikasi>, transportasi <transportasi>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field gapok kosong

    Examples: 
      | nik                              | gapok   | jabatan | komunikasi | transportasi | vaksin   | tgl        | note          |
      | EXD8200015 - EX - ADHITYA BAYU W |         | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | haha    | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |
      | EXD8200015 - EX - ADHITYA BAYU W | (^-.-^) | 1000000 |     200000 |       200000 | Vaksin 1 | 2022-02-21 | Segera vaksin |

  @tag2
  Scenario Outline: Add data Promosi jabatan dengan *field_vaksin* Kosong
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
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field vaksin kosong

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               |   | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | 2 | sdasf |

  @tag3
  Scenario Outline: Add data Promosi jabatan dengan *field_note* Kosong
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
    And Validasi field note kosong

    Examples: 
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 |      |

  Scenario Outline: Add data Promosi jabatan dengan *tabelPenilaian*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih nik <nik>
    And User memilih tglEf <tglEf>, status <status>, unit <unit>, perubahan jabatan <jabatan>, divisi <divisi>, level <level>
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
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | kelebihan | grow  | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   | Disiplin  | Fokus | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  Scenario Outline: Add data Promosi jabatan dengan *field_aspek* variasi data
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
      | nik                              | tglEf      | status | unit         | jabatan | divisi      | level | opt01 | opt02 | opt03 | opt04 | opt05 | opt06 | opt07 | opt08 | opt09 | opt10 | kelebihan | grow    | asuransi | ulasan               | vaksin   | tgl        | note  |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 |     11111 | Fokus   | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | (^-,-^)   | Fokus   | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 |           | Fokus   | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  |   11111 | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | (^-,-^) | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  |         | BPJS K   | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus   |    11111 | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus   | (^-,-^)  | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | PKWT   | Angkasa Pura | ASM     | Operational | ASM   |     6 |     4 |     7 |     5 |     4 |     3 |     4 |     4 |     4 |     4 | Disiplin  | Fokus   |          | Lulus Masa Percobaan | Vaksin 2 | 2022-01-12 | sdasf |

  @cek1
  Scenario Outline: Checklist tujuan promosi 2
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih tujuan promosi perubahan kontrak
    Then Validasi tujuan promosi 2

  Scenario Outline: Checklist tujuan promosi 3
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan jabatan
    And User memilih tujuan promosi perubahan kontrak
    And User memilih tujuan promosi perubahan salary
    Then Validasi tujuan promosi 3

  @Unchecklist
  Scenario Outline: Unchecklist tujuan promosi
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User mengisi jenis vaksin <vaksin>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | vaksin       | note        |
      | Belum Vaksin | Vaksin Shay |
