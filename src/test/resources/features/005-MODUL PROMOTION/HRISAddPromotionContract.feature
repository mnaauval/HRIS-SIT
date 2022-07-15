#Author: intanjuniar101@gmail.com
Feature: Add Pengajuan Promotion

  Scenario Outline: Action click *AddData*
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    Then User add

  Scenario Outline: Tampil pesan sukses jika data berhasil ditambahkan
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-14 | 2023-07-15 |   0  | Vaksin 2 | 2022-07-17 | Perbarui sertifikasi keahlian |

  Scenario Outline: Tampil sent to uplier
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi kolom Appr

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2023-07-15 |   12 | Vaksin 2 | 2022-07-17 | Perbarui sertifikasi keahlian |

  Scenario Outline: Add data Perubahan kontrak dengan *field_start* and *field_end* >=current
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2023-07-15 |   12 | Vaksin 2 | 2022-01-12 | Perbarui sertifikasi keahlian |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-12 | 2023-07-12 |   12 | Vaksin 1 | 2022-07-12 | Perbarui berkas kontrak       |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-09 | 2022-10-12 |   12 | Vaksin 1 | 2022-07-12 | Perbarui berkas kontrak       |
      #end >=start
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2022-09-15 |    2 | Vaksin 1 | 2022-04-12 | Perbarui sertifikasi keahlian |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2022-07-15 |    0 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak       |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2022-07-10 |    0 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak       |

  @coba
  Scenario Outline: Add data Perubahan kontrak dengan *field_start* < current_time
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field start kosong

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                    |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-09 | 2022-10-12 |   12 | Vaksin 1 | 2022-07-12 | Perbarui berkas kontrak |

  @coba
  Scenario Outline: Add data Perubahan kontrak dengan *field_end*  < start
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field end kosong

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                    |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2022-07-10 |    0 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |

  @vaksin
  Scenario Outline: Add data Perubahan kontrak dengan *field_vaksin* >=< current
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2023-07-15 |   12 | Vaksin 2 | 2022-07-17 | Perbarui sertifikasi keahlian |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-12 | 2023-07-12 |   12 | Vaksin 1 | 2022-07-10 | Perbarui berkas kontrak       |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2022-09-15 |    2 | Vaksin 2 | 2022-04-15 | Perbarui sertifikasi keahlian |

  Scenario Outline: Add data Perubahan kontrak dengan *masa* edit > < auto sum
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-20 | 2023-07-20 |   13 | Vaksin 2 | 2022-07-17 | Perbarui sertifikasi keahlian |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-20 | 2023-07-20 |   11 | Vaksin 1 | 2022-07-10 | Perbarui berkas kontrak       |

  #| EXD8200015 - EX - ADHITYA BAYU W | 2022-07-20 | 2022-07-25 |    0 | Vaksin 2 | 2022-04-15 | Perbarui sertifikasi keahlian |
  #| EXD8200015 - EX - ADHITYA BAYU W | 2022-07-20 | 2022-07-25 |   -1 | Vaksin 2 | 2022-04-15 | Perbarui sertifikasi keahlian |
  Scenario Outline: Add data Perubahan kontrak dengan *field_vaksin* pilih belum vaksin
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan
    And Validasi sent to uplier
    And Kembali ke halaman promotion

    Examples: 
      | nik                              | start      | end        | masa | vaksin       | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2023-07-15 |   12 | Belum Vaksin | Perbarui sertifikasi keahlian |

  Scenario Outline: Add data Perubahan kontrak dengan *field_start* tgl vaksin kosong [-]
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2023-07-15 |   12 | Vaksin 2 | Perbarui sertifikasi keahlian |

  Scenario Outline: Add data Perubahan kontrak dengan *field_start* < current time [-]
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin       | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-01 | 2023-07-15 |   12 | Belum Vaksin | Perbarui sertifikasi keahlian |

  @tag3
  Scenario Outline: Add data Perubahan kontrak dengan *field_note* variasi data [-]
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi data tersimpan

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                          |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-16 | 2023-07-13 |   12 | Vaksin 2 | 2022-02-12 |                  012123456789 |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-16 | 2022-10-12 |    3 | Vaksin 2 | 2022-02-12 | "_"Perbarui berkas kontrak!!! |

  @tag
  Scenario Outline: Add data Perubahan kontrak dengan *field_start* kosong [-]
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal selesai kontrak <end>
    And User memilih masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field start kosong

    Examples: 
      | nik                              | end        | masa | vaksin   | tgl        | note                    |
      | EXD8200015 - EX - ADHITYA BAYU W | 2023-07-01 |   12 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |

  Scenario Outline: Add data Perubahan kontrak dengan *field_end* < current time [-]
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai kontrak <start>
    And User memilih masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field end kosong

    Examples: 
      | nik                              | start      | masa | vaksin   | tgl        | note                    |
      | EXD8200015 - EX - ADHITYA BAYU W | 2023-07-01 |   12 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |

  Scenario Outline: Add data Perubahan kontrak dengan *field_masa* kosong [-]
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai <start>, tanggal selesai <end>, masa <masa>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field masa kosong

    Examples: 
      | nik                              | start      | end        | masa | vaksin   | tgl        | note                    |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-01 | 2023-04-01 |      | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |

  @showAutoSum
  Scenario Outline: Add data Perubahan kontrak dengan *field_masa* show auto sum, masa =0 & < 0
    Given User login sebagai Manager
    When User masuk pada Homepage
    And User menekan teks promotion pada Navigation Menu
    And User menekan Promotion pada submenu Navigation
    And User add
    And User memilih tujuan promosi perubahan kontrak
    And User memilih nik <nik>
    And User memilih tanggal mulai kontrak <start>
    And User memilih tanggal selesai kontrak <end>
    And User mengisi jenis vaksin <vaksin>
    And User mengisi tanggal vaksin <tgl>
    And User mengisi note <note>
    And User klik tombol sent to uplier
    Then Data tersimpan
    And Validasi field masa jabatan < 0

    Examples: 
      | nik                              | start      | end        | vaksin   | tgl        | note                    |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-01 | 2023-04-01 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-01 | 2022-04-01 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |
      | EXD8200015 - EX - ADHITYA BAYU W | 2022-07-15 | 2022-07-21 | Vaksin 2 | 2022-02-12 | Perbarui berkas kontrak |
