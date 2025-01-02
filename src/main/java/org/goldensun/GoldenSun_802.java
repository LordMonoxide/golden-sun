package org.goldensun;

import org.goldensun.battle.BattleStruct82c;
import org.goldensun.memory.Method;
import org.goldensun.memory.types.ArrayRef;
import org.goldensun.memory.types.UnsignedShortRef;
import org.goldensun.types.ChoiceMenu98;
import org.goldensun.types.GraphicsStruct1c;
import org.goldensun.types.Item2c;
import org.goldensun.types.Panel24;
import org.goldensun.types.RenderPacket0c;
import org.goldensun.types.SaveStruct1100;
import org.goldensun.types.Sprite38;
import org.goldensun.types.Struct12fc;
import org.goldensun.types.Unit14c;
import org.goldensun.types.Vec3;

import javax.annotation.Nullable;

import static org.goldensun.GoldenSun.FUN_800387c;
import static org.goldensun.GoldenSun.allocateSpriteSlot;
import static org.goldensun.GoldenSun.allocateFirstFreeSpriteSlot;
import static org.goldensun.GoldenSun.FUN_80040d0;
import static org.goldensun.GoldenSun.FUN_80053e8;
import static org.goldensun.GoldenSun.FUN_8005a78;
import static org.goldensun.GoldenSun.FUN_8009288;
import static org.goldensun.GoldenSun.addRotScaleParams;
import static org.goldensun.GoldenSun.clearSprite_;
import static org.goldensun.GoldenSun.clearTickCallback;
import static org.goldensun.GoldenSun.clearVramSlot;
import static org.goldensun.GoldenSun.decompress;
import static org.goldensun.GoldenSun.divideS;
import static org.goldensun.GoldenSun.drawSprite_;
import static org.goldensun.GoldenSun.freeSlot;
import static org.goldensun.GoldenSun.getFreeVramSlot;
import static org.goldensun.GoldenSun.getPointerTableEntry;
import static org.goldensun.GoldenSun.insertIntoRenderQueue;
import static org.goldensun.GoldenSun.loadSaveList;
import static org.goldensun.GoldenSun.loadSavePreview;
import static org.goldensun.GoldenSun.loadUiTextures;
import static org.goldensun.GoldenSun.mallocBoard;
import static org.goldensun.GoldenSun.mallocChip;
import static org.goldensun.GoldenSun.mallocSlotBoard;
import static org.goldensun.GoldenSun.mallocSlotChip;
import static org.goldensun.GoldenSun.modS;
import static org.goldensun.GoldenSun.rand;
import static org.goldensun.GoldenSun.saveGame;
import static org.goldensun.GoldenSun.setInterruptHandler;
import static org.goldensun.GoldenSun.setMallocAddress;
import static org.goldensun.GoldenSun.setTickCallback;
import static org.goldensun.GoldenSun.sin;
import static org.goldensun.GoldenSun.sleep;
import static org.goldensun.GoldenSun.unloadSaveList;
import static org.goldensun.GoldenSunVars._3001c9c;
import static org.goldensun.GoldenSunVars._3001d08;
import static org.goldensun.GoldenSunVars._3001e40;
import static org.goldensun.GoldenSunVars._3001f64;
import static org.goldensun.GoldenSunVars.boardWramMallocHead_3001e50;
import static org.goldensun.GoldenSunVars.debug_3001f54;
import static org.goldensun.GoldenSunVars.framesSinceInput_3001d24;
import static org.goldensun.GoldenSunVars.heldButtonsLastFrame_3001ae8;
import static org.goldensun.GoldenSunVars.lastSaveSlot_2002004;
import static org.goldensun.GoldenSunVars.pressedButtons_3001b04;
import static org.goldensun.GoldenSunVars.pressedButtons_3001c94;
import static org.goldensun.GoldenSunVars.ticks_3001800;
import static org.goldensun.GoldenSunVars.vramSlots_3001b10;
import static org.goldensun.GoldenSun_801.FUN_8016418;
import static org.goldensun.GoldenSun_801.FUN_8016478;
import static org.goldensun.GoldenSun_801.FUN_80165d8;
import static org.goldensun.GoldenSun_801.FUN_801671c;
import static org.goldensun.GoldenSun_801.FUN_8016738;
import static org.goldensun.GoldenSun_801.FUN_8017364;
import static org.goldensun.GoldenSun_801.FUN_8017658;
import static org.goldensun.GoldenSun_801.FUN_801776c;
import static org.goldensun.GoldenSun_801.FUN_8017a64;
import static org.goldensun.GoldenSun_801.FUN_8017aa4;
import static org.goldensun.GoldenSun_801.FUN_8018850;
import static org.goldensun.GoldenSun_801.FUN_8018efc;
import static org.goldensun.GoldenSun_801.FUN_8019000;
import static org.goldensun.GoldenSun_801.FUN_801965c;
import static org.goldensun.GoldenSun_801.FUN_8019908;
import static org.goldensun.GoldenSun_801.FUN_8019a54;
import static org.goldensun.GoldenSun_801.FUN_8019ba0;
import static org.goldensun.GoldenSun_801.FUN_8019d2c;
import static org.goldensun.GoldenSun_801.FUN_8019da8;
import static org.goldensun.GoldenSun_801.FUN_8019e48;
import static org.goldensun.GoldenSun_801.FUN_801a088;
import static org.goldensun.GoldenSun_801.FUN_801a3d0;
import static org.goldensun.GoldenSun_801.FUN_801a4fc;
import static org.goldensun.GoldenSun_801.FUN_801ccc0;
import static org.goldensun.GoldenSun_801.FUN_801d4cc;
import static org.goldensun.GoldenSun_801.FUN_801db70;
import static org.goldensun.GoldenSun_801.FUN_801e318;
import static org.goldensun.GoldenSun_801.FUN_801e41c;
import static org.goldensun.GoldenSun_801.FUN_801e71c;
import static org.goldensun.GoldenSun_801.FUN_801e74c;
import static org.goldensun.GoldenSun_801.FUN_801e7c0;
import static org.goldensun.GoldenSun_801.FUN_801e858;
import static org.goldensun.GoldenSun_801.FUN_801e8b0;
import static org.goldensun.GoldenSun_801.FUN_801e940;
import static org.goldensun.GoldenSun_801.FUN_801ea08;
import static org.goldensun.GoldenSun_801.FUN_801eadc;
import static org.goldensun.GoldenSun_801.FUN_801f77c;
import static org.goldensun.GoldenSun_801.FUN_801f818;
import static org.goldensun.GoldenSun_801.FUN_801fd84;
import static org.goldensun.GoldenSun_801.FUN_801fd98;
import static org.goldensun.GoldenSun_801.FUN_801fda8;
import static org.goldensun.GoldenSun_801.addPanel;
import static org.goldensun.GoldenSun_801.clearCharacterSprites;
import static org.goldensun.GoldenSun_801.decodeTime;
import static org.goldensun.GoldenSun_801.drawNumber;
import static org.goldensun.GoldenSun_801.drawPanelBackground;
import static org.goldensun.GoldenSun_801.loadCharacterSprites;
import static org.goldensun.GoldenSun_801.loadDjinnSprites;
import static org.goldensun.GoldenSun_807.getSummon_;
import static org.goldensun.GoldenSun_807.FUN_80771e8;
import static org.goldensun.GoldenSun_807.FUN_8077208;
import static org.goldensun.GoldenSun_807.FUN_80772b8;
import static org.goldensun.GoldenSun_807.calculateBuildDate_;
import static org.goldensun.GoldenSun_807.getAbility_;
import static org.goldensun.GoldenSun_807.getCharOrMonsterData_;
import static org.goldensun.GoldenSun_807.getDjinnCount_;
import static org.goldensun.GoldenSun_807.getDjinnRecoveryQueue_;
import static org.goldensun.GoldenSun_807.getItem_;
import static org.goldensun.GoldenSun_807.isEquipped_;
import static org.goldensun.GoldenSun_807.readFlag_;
import static org.goldensun.GoldenSun_808.FUN_808a5b0;
import static org.goldensun.GoldenSun_80b.FUN_80b0020;
import static org.goldensun.GoldenSun_80b.FUN_80b0028;
import static org.goldensun.GoldenSun_80b.FUN_80b0030;
import static org.goldensun.GoldenSun_80b.FUN_80b0038;
import static org.goldensun.GoldenSun_80b.getUnitIds_;
import static org.goldensun.GoldenSun_80b.FUN_80b50b8;
import static org.goldensun.GoldenSun_80b.FUN_80b50d0;
import static org.goldensun.GoldenSun_80b.FUN_80b50e0;
import static org.goldensun.GoldenSun_80b.FUN_80b5128;
import static org.goldensun.GoldenSun_80b.FUN_80b5130;
import static org.goldensun.GoldenSun_80f.FUN_80f9048;
import static org.goldensun.GoldenSun_80f.playSound_;
import static org.goldensun.Hardware.CPU;
import static org.goldensun.Hardware.DMA;
import static org.goldensun.Hardware.GPU;
import static org.goldensun.Hardware.INTERRUPTS;
import static org.goldensun.Hardware.MEMORY;
import static org.goldensun.input.Input.BUTTON_A;
import static org.goldensun.input.Input.BUTTON_B;
import static org.goldensun.input.Input.BUTTON_DOWN;
import static org.goldensun.input.Input.BUTTON_LEFT;
import static org.goldensun.input.Input.BUTTON_RIGHT;
import static org.goldensun.input.Input.BUTTON_UP;
import static org.goldensun.memory.MemoryHelper.getRunnable;

public final class GoldenSun_802 {
  private GoldenSun_802() { }

  @Method(0x8020088)
  public static void clearDjinnSprites() {
    final int r7 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    clearTickCallback(getRunnable(GoldenSun_802.class, "drawDjinn"));

    //LAB_80200a2
    for(int r6 = 0; r6 < 4; r6++) {
      final int r0 = MEMORY.ref(4, r7 + 0x224 + r6 * 0x4).get();
      if(r0 != 0) {
        clearSprite_(MEMORY.ref(4, r0, Sprite38::new));
        MEMORY.ref(4, r7 + 0x224 + r6 * 0x4).setu(0);
      }

      //LAB_80200b0
    }
  }

  @Method(0x80200cc)
  public static void drawDjinn() {
    CPU.sp().value -= 0x1c;

    final int r3 = boardWramMallocHead_3001e50.offset(55 * 0x4).get();
    final int r4 = CPU.sp().value + 0x4;
    final int r5 = CPU.sp().value + 0xc;

    //LAB_80200fa
    for(int r8 = 0; r8 < 4; r8++) {
      final int r0 = MEMORY.ref(4, r3 + 0x224 + r8 * 0x4).get();

      if(r0 != 0) {
        MEMORY.ref(4, r4).setu(0x10000);
        MEMORY.ref(4, r4 + 0x4).setu(0x10000);

        MEMORY.ref(4, r5).setu(MEMORY.ref(2, r3 + 0x234 + r8 * 0x2).get() << 16);
        MEMORY.ref(4, r5 + 0x4).setu(0x1f40000);
        MEMORY.ref(4, r5 + 0x8).setu(0x1f40000 + (MEMORY.ref(2, r3 + 0x234 + 0x8 + r8 * 0x2).get() << 16));
        MEMORY.ref(4, r5 + 0xc).setu(0);

        drawSprite_(MEMORY.ref(4, r0, Sprite38::new), r5, r4, 0x4000);
      }

      //LAB_8020130
    }

    CPU.sp().value += 0x1c;
  }

  @Method(0x8020150)
  public static void drawDjinnCounts(final Panel24 panel, final SaveStruct1100.Preview40 preview) {
    if(panel != null) {
      //LAB_802016a
      for(int djinnTypeIndex = 0; djinnTypeIndex < 4; djinnTypeIndex++) {
        drawNumber(preview.djinnCounts_28.get(djinnTypeIndex).get(), 2, panel, djinnTypeIndex * 24, 16);
      }
    }

    //LAB_802018c
  }

  @Method(0x8020198)
  public static void drawSavePreview(final Panel24 panel, final SaveStruct1100.Preview40 preview) {
    CPU.sp().value -= 0x14;

    if(panel != null) {
      FUN_8016478(panel);
      FUN_801e41c(panel, 0, 0x4, 0xd, 0x4);
      FUN_801e8b0(preview.name_10.getAddress(), panel, 0, 0); // name
      FUN_801e940(0x80371e0, panel, 72, 0); // "L" for level
      drawNumber(preview.level_1c.get(), 2, panel, 80, 0); // level
      FUN_801e7c0(preview.class_1d.get() + 0x741, panel, 0, 16); // class
      FUN_801e7c0(9, panel, 0, 32); // "Play Time:"
      FUN_801e940(decodeTime(preview.time_20.get(), CPU.sp().value + 0x4), panel, 48, 40); // time
      FUN_801ea08(preview.coins_24.get(), 0x6, panel, 0, 48); // coins
      FUN_801e7c0(0xc88, panel, 48, 48); // "Coins"
    }

    //LAB_802022c
    CPU.sp().value += 0x14;
  }

  @Method(0x8020244)
  public static int drawSaveMenu(int selectedFile, final int mode) {
    CPU.sp().value -= 0x28;
    int r5 = mallocSlotChip(55, 0xa70);
    final SaveStruct1100 r7 = boardWramMallocHead_3001e50.offset(51 * 0x4).deref(4).cast(SaveStruct1100::new);
    Panel24 savePanel = null;
    Panel24 characterPanel = null;
    Panel24 djinnPanel = null;
    int sp0c = 1;
    final Struct12fc sp08 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final int buildDate = calculateBuildDate_();
    if(selectedFile < 0) {
      selectedFile = 0;
    }

    //LAB_802028a
    int menuIndex;
    if(mode == 1) { // continue
      //LAB_802029e
      //LAB_80202bc
      for(menuIndex = 0; menuIndex < 3 && r7._1040.get(selectedFile).level_1c.get() == 0 || r7._1040.get(selectedFile)._31.get() != 0; menuIndex++) {
        selectedFile++;
        if(selectedFile == 3) {
          selectedFile = 0;
        }

        //LAB_80202ac
      }

      if(menuIndex == 3) {
        CPU.sp().value += 0x28;
        return -2;
      }
      //LAB_80202d2
    } else if(mode == 4) { // battle
      //LAB_80202e6
      //LAB_8020304
      for(menuIndex = 0; menuIndex < 3 && r7._1040.get(selectedFile).level_1c.get() == 0 || r7._1040.get(selectedFile)._32.get() == 0; menuIndex++) {
        selectedFile++;
        if(selectedFile == 3) {
          selectedFile = 0;
        }

        //LAB_80202f4
      }

      if(menuIndex == 3) {
        CPU.sp().value += 0x28;
        return -2;
      }
      //LAB_802031a
    } else if(mode == 5) { // transfer
      //LAB_802032e
      //LAB_802034c
      for(menuIndex = 0; menuIndex < 3 && r7._1040.get(selectedFile).level_1c.get() == 0 || r7._1040.get(selectedFile)._31.get() == 0; menuIndex++) {
        selectedFile++;
        if(selectedFile == 3) {
          selectedFile = 0;
        }

        //LAB_802033c
      }

      if(menuIndex == 3) {
        CPU.sp().value += 0x28;
        return -2;
      }
      //LAB_8020362
    } else if(mode != 0) {
      //LAB_802037c
      for(menuIndex = 0; menuIndex < 3 && r7._1040.get(selectedFile).level_1c.get() == 0; menuIndex++) {
        selectedFile++;
        if(selectedFile == 3) {
          selectedFile = 0;
        }

        //LAB_802038e
      }

      //LAB_802039a
      if(menuIndex == 3) {
        CPU.sp().value += 0x28;
        return -2;
      }
    }

    //LAB_80203b0
    MEMORY.ref(4, CPU.sp().value + 0x24).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value + 0x24);
    DMA.channels[3].DAD.setu(r5);
    DMA.channels[3].CNT.setu(0x8500029c);

    FUN_801fd84();
    final Panel24 saveListPanel = addPanel(1, 2, 28, 7, 0x2);

    //LAB_80203e8
    for(menuIndex = 0; menuIndex < 3; menuIndex++) {
      final int rowY = menuIndex * 0x10;
      final SaveStruct1100.Preview40 preview = r7._1040.get(menuIndex);
      if(preview.level_1c.get() == 0) {
        FUN_801e74c(0, saveListPanel, 10, rowY);
      } else {
        //LAB_80203f2
        if(preview.buildDate_36.get() < buildDate) {
          FUN_801e74c(0x1, saveListPanel, 10, rowY); // (Continue from sanctum)
        } else {
          //LAB_80203fe
          if(preview.time_20.get() != preview._38.get()) {
            FUN_801e74c(0x3, saveListPanel, 10, rowY); // (The data is corrupted)
          } else {
            //LAB_802040a
            if(mode == 0x5 && preview._31.get() == 0) {
              FUN_801e74c(0x2, saveListPanel, 10, rowY); // (Not cleared yet)
            } else {
              //LAB_8020426
              FUN_801e858(preview.name_10.getAddress(), saveListPanel, 12, rowY);
              FUN_801e74c(preview.location_1e.get() + 0x99b, saveListPanel, 62, rowY);
              sp08._ea3.set(0x1);
            }
          }
        }
      }
    }

    FUN_801e41c(saveListPanel, 0, 2, 27, 2);
    FUN_801e41c(saveListPanel, 0, 4, 27, 4);
    final GraphicsStruct1c sp10 = FUN_8021620(mode, saveListPanel, 72, -24);

    //LAB_8020494
    do {
      if(sp0c != 0) {
        //LAB_802049c
        sp0c = 0;
        final SaveStruct1100.Preview40 preview = r7._1040.get(selectedFile);
        if(preview.level_1c.get() != 0) {
          //LAB_80204b0
          FUN_801ccc0(preview._34.get(), preview._35.get());
          if(savePanel == null) {
            savePanel = addPanel(1, 10, 14, 9, 0x2);
          }

          //LAB_80204d6
          drawSavePreview(savePanel, preview);
          sleep(1);
          if(characterPanel == null) {
            characterPanel = addPanel(16, 10, 13, 3, 0x2);
          }

          //LAB_8020504
          clearCharacterSprites();
          loadCharacterSprites(characterPanel, 0, 0, preview);
          sleep(1);

          if(preview.djinnCounts_28.get(0).get() + preview.djinnCounts_28.get(1).get() + preview.djinnCounts_28.get(2).get() + preview.djinnCounts_28.get(3).get() != 0) {
            if(djinnPanel == null) {
              djinnPanel = addPanel(16, 14, 13, 5, 0x2);
            }

            //LAB_8020552
            drawDjinnCounts(djinnPanel, preview);
            clearDjinnSprites();
            loadDjinnSprites(djinnPanel, 0, 0);
          } else {
            //LAB_802056a
            clearDjinnSprites();
            FUN_8016418(djinnPanel, 0x2);
            djinnPanel = null;
          }
        } else {
          //LAB_80205ac
          FUN_801ccc0(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
          clearDjinnSprites();
          clearCharacterSprites();
          FUN_8016418(djinnPanel, 0x2);
          FUN_8016418(characterPanel, 0x2);
          FUN_8016418(savePanel, 0x2);
          djinnPanel = null;
          characterPanel = null;
          savePanel = null;
        }

        //LAB_80205e6
        drawPanelBackground(saveListPanel);
        FUN_801e41c(saveListPanel, 0, 2, 27, 2); // Bar between save slot 1 and 2
        FUN_801e41c(saveListPanel, 0, 4, 27, 4); // Bar between save slot 2 and 3
        FUN_801fda8(saveListPanel, 0, selectedFile * 2, 26, 1); // Selected save hightlight
      }

      //LAB_802061e
      FUN_80216b4(sp10);
      sleep(1);

      if((pressedButtons_3001b04.get() & BUTTON_UP) != 0) {
        playSound_(0x6f);
        sp0c = 1;
        selectedFile = modS(selectedFile + 0x2, 0x3);

        //LAB_8020642
        //LAB_8020696
        while(mode != 0) {
          if(r7._1040.get(selectedFile).level_1c.get() != 0) {
            if(mode != 1 || r7._1040.get(selectedFile)._31.get() == 0) {
              if(mode != 4 || r7._1040.get(selectedFile)._32.get() != 0) {
                if(mode != 5 || r7._1040.get(selectedFile)._31.get() != 0) {
                  break;
                }
              }
            }
          }

          selectedFile = modS(selectedFile + 0x2, 0x3);
        }
      } else {
        //LAB_80206aa
        if((pressedButtons_3001b04.get() & BUTTON_DOWN) != 0) {
          playSound_(0x6f);
          sp0c = 1;
          selectedFile = modS(selectedFile + 0x4, 0x3);

          //LAB_80206c0
          while(mode != 0) {
            if(r7._1040.get(selectedFile).level_1c.get() != 0) {
              if(mode != 1 || r7._1040.get(selectedFile)._31.get() == 0) {
                if(mode != 4 || r7._1040.get(selectedFile)._32.get() != 0) {
                  if(mode != 5 || r7._1040.get(selectedFile)._31.get() != 0) {
                    break;
                  }
                }
              }
            }

            //LAB_8020714
            selectedFile = modS(selectedFile + 0x4, 0x3);
          }
        } else {
          //LAB_8020728
          if((pressedButtons_3001c94.get() & BUTTON_B) != 0) {
            //LAB_80203a4
            playSound_(0x71);
            r5 = -1;
            break;
          }

          //LAB_8020736
          if((pressedButtons_3001c94.get() & BUTTON_A) != 0) {
            //LAB_8020742
            playSound_(0x70);
            r5 = selectedFile;
            break;
          }
        }
      }
    } while(true);

    //LAB_802074a
    clearDjinnSprites();
    clearCharacterSprites();
    FUN_8016418(djinnPanel, 0x2);
    FUN_8016418(characterPanel, 0x2);
    FUN_8016418(savePanel, 0x2);
    FUN_8016418(saveListPanel, 0x2);
    FUN_801fd98();
    freeSlot(55);
    FUN_801ccc0(MEMORY.ref(1, 0x2000445).getUnsigned(), MEMORY.ref(1, 0x2000446).getUnsigned());
    sleep(1);

    //LAB_8020794
    CPU.sp().value += 0x28;
    return r5;
  }

  /** Save game menu */
  @Method(0x80207c4)
  public static int FUN_80207c4() {
    int r8 = 0;
    int r6 = loadSaveList();
    if(r6 != 0) {
      FUN_801776c(0xa, 0x1);
      r8 = -9;
    } else {
      //LAB_80207e8
      loadSavePreview();
      final int r5 = boardWramMallocHead_3001e50.offset(51 * 0x4).get();
      final int selectedSaveSlot = drawSaveMenu(lastSaveSlot_2002004.get(), 0);
      if(selectedSaveSlot == -1) {
        r8 = -1;
      } else {
        //LAB_802080a
        if(MEMORY.ref(1, r5 + 0x105c + selectedSaveSlot * 0x40).getUnsigned() != 0) {
          FUN_801776c(0x14, 0xd);

          //LAB_8020820
          //LAB_8020826
          while(FUN_8017364() == 0) {
            sleep(1);
          }

          if(FUN_8028df4(1, 0, 0, 1) != 0) {
            FUN_8019a54();
            unloadSaveList();
            return 0;
          }

          //LAB_8020844
          FUN_8019a54();
        }

        //LAB_8020848
        lastSaveSlot_2002004.set(selectedSaveSlot);
        playSound_(0x55);
        FUN_801776c(0x1a, 0xd);

        //LAB_802085c
        //LAB_8020862
        while(FUN_8017364() == 0) {
          sleep(1);
        }

        FUN_801f818();
        FUN_808a5b0();
        r6 = saveGame(selectedSaveSlot, 0x2000000) | saveGame(selectedSaveSlot + 0x3, 0x2001000);
        FUN_8019a54();
        if(r6 != 0) {
          FUN_801776c(0xb, 0x1);
          r8 = -3;
        } else {
          //LAB_80208a6
          FUN_801776c(0x17, 0x9);
        }
      }
    }

    //LAB_80208ae
    unloadSaveList();
    return r8;
  }

  @Method(0x80208e4)
  public static int loadLoadGameMenu(final int mode) {
    int r8 = 0;
    if(loadSaveList() != 0) {
      FUN_801776c(0xa, 0x1);
      r8 = -9;
    } else {
      //LAB_802090c
      loadSavePreview();
      final int selectedSaveSlot = drawSaveMenu(lastSaveSlot_2002004.get(), mode);
      if(selectedSaveSlot == -1) {
        r8 = -1;
        //LAB_802092c
      } else if((FUN_8005a78(selectedSaveSlot, 0x2000000) | FUN_8005a78(selectedSaveSlot + 3, 0x2001000)) != 0) {
        FUN_801776c(0xc, 0x1);
        r8 = -2;
      } else {
        //LAB_802095c
        _3001c9c.set(MEMORY.ref(4, 0x2000244).get());
        _3001d08.set(MEMORY.ref(1, 0x200046a).getUnsigned());
        framesSinceInput_3001d24.set(0);
        lastSaveSlot_2002004.set(selectedSaveSlot);
      }
    }

    //LAB_8020978
    unloadSaveList();
    return r8;
  }

  /** Maybe decompressing a graphic and uploading to VRAM (uploads name entry keyboard to GPU) */
  @Method(0x80209d0)
  public static void FUN_80209d0(final Panel24 r0_0, final int r1) {
    final int r10 = mallocBoard(0x300);
    decompress(r1, r10);
    int r3 = r0_0.x_0c.get() + r0_0.y_0e.get() * 0x20;
    final int r4 = r0_0.h_0a.get(); // maybe height
    int r7 = r10;
    int r0 = 0x6002000 + r3 * 0x2;
    int r6 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new)._00.getAddress() + r3 * 0x2; //TODO
    final int r2 = r0_0.w_08.get(); // maybe width

    //LAB_8020a14
    for(int i = 0; i < r4; i++) {
      //LAB_8020a1a
      for(int n = 0; n < r2; n++) {
        r3 = MEMORY.ref(2, r7).get();
        MEMORY.ref(2, r0).setu(r3);
        MEMORY.ref(2, r6).setu(r3);
        r7 += 0x2;
        r0 += 0x2;
        r6 += 0x2;
      }

      //LAB_8020a32
      r3 = (32 - r2) * 2;
      r0 += r3;
      r6 += r3;
    }

    //LAB_8020a44
    setMallocAddress(r10);
  }

  @Method(0x8020a60)
  public static void FUN_8020a60(final Panel24 r0, int r1, int r2, final int r3, final int a4, final int a5) {
    final Struct12fc r12 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r1 = r1 + r0.x_0c.get() + 0x1;
    r2 = r2 + r0.y_0e.get() + 0x1;

    int r6 = r3;
    if(r1 < 0) {
      r6 = r6 + r1;
      r1 = 0;
    }

    //LAB_8020a84
    if(r1 + r6 > 0x1d) {
      r6 = 0x1e - r1;
    }

    //LAB_8020a8e
    int r5 = a4;
    if(r2 < 0) {
      r5 = r5 + r2;
      r2 = 0;
    }

    //LAB_8020a96
    if(r2 + r5 > 0x1d) {
      r5 = 0x14 - r2;
    }

    //LAB_8020aa0
    if(r6 <= 0 || r5 <= 0) {
      return;
    }

    r1 = r2 * 0x40 + r1 * 0x2;

    //LAB_8020aae
    for(int n = 0; n < r5; n++) {
      int r4 = r12._00.getAddress() + r1; //TODO

      //LAB_8020aba
      for(int i = 0; i < r6; i++) {
        MEMORY.ref(2, r4).and(~0x1000).oru(a5 << 12);
        r4 += 0x2;
      }

      //LAB_8020aca
      r1 += 0x40;
    }

    r12._ea3.set(0x1);

    //LAB_8020ada
  }

  @Method(0x8020b14)
  public static int FUN_8020b14(final int r0) {
    final Struct12fc r4 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    CPU.sp().value -= 0x8;
    int r1 = 0;

    //LAB_8020b2a
    while(MEMORY.ref(1, r0 + r1).getUnsigned() != 0) {
      r4.text_eb0.get(r1).set(MEMORY.ref(1, r0 + r1).getUnsigned());
      r1++;
    }

    //LAB_8020b3a
    r4.text_eb0.get(r1).set(0);
    FUN_8018850(0, CPU.sp().value + 0x4, CPU.sp().value, null);
    final int ret = MEMORY.ref(4, CPU.sp().value + 0x4).get();
    CPU.sp().value += 0x8;
    return ret;
  }

  @Method(0x8020b64)
  public static void FUN_8020b64(final Panel24 r0, int r1) {
    CPU.sp().value -= 0x14;
    int r2;
    int r4 = 0;

    //LAB_8020b78
    while((r2 = MEMORY.ref(1, r1++).getUnsigned()) != 0) {
      MEMORY.ref(1, CPU.sp().value + r4++).setu(r2);
    }

    //LAB_8020b8e
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0x8);
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0x2);

    if(r4 < 7) {
      r2 = CPU.sp().value + r4;
      r4 = 7 - r4;

      //LAB_8020ba6
      while(r4 != 0) {
        MEMORY.ref(1, r2++).setu(0x5f);
        r4--;
      }

      r4 = 7;
    }

    //LAB_8020bb2
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0x8);
    MEMORY.ref(1, CPU.sp().value + r4++).setu(0xf);
    MEMORY.ref(1, CPU.sp().value + r4).setu(0);
    FUN_801e858(CPU.sp().value, r0, 0, -2);
    CPU.sp().value += 0x14;
  }

  @Method(0x8020bd8)
  public static int FUN_8020bd8(int r0) {
    int r1;
    final int r2;
    int r3;
    int r5;
    int r6;
    int r7;
    int r9;

    CPU.sp().value -= 0x60;
    int sp24 = 0;
    int sp20 = 0;
    int sp1c = 0;
    final int sp18 = CPU.sp().value + 0x51;
    final int sp2c = r0;
    final Unit14c charData = getCharOrMonsterData_(r0);
    final Struct12fc sp10 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    int sp0c = 0x1;
    r9 = 0x1;
    loadUiTextures();
    final Panel24 r8 = addPanel(0x3, 0x6, 0x18, 0x9, 0x2);
    final Panel24 sp28 = addPanel(0x8, 0x3, 0x8, 0x3, 0x2);
    FUN_8019da8(FUN_8019d2c(sp2c), 0, 3, 1);
    FUN_80209d0(r8, 0x8073864); // Upload name entry keyboard to GPU
    FUN_801e41c(r8, 0x12, 0, 0x12, 0x7); // I think this adds the inside borders to the name entry box
    sp10._ea3.set(sp0c);
    MEMORY.ref(1, CPU.sp().value + 0x50).setu(sp24);

    //LAB_8020c74
    for(r1 = 0; r1 < 14; r1++) {
      final int chr = MEMORY.ref(1, charData.name_00.getAddress() + r1).getUnsigned();
      MEMORY.ref(1, sp18 + r1).setu(chr);
      if(chr != 0) {
        sp20++;
        sp1c++;
      }

      //LAB_8020c8c
    }

    MEMORY.ref(1, sp18 + 0xe).setu(0);
    FUN_8020b64(sp28, charData.getAddress());
    r6 = 0x12;
    r7 = 0x5;
    r5 = getFreeVramSlot();
    if(r5 < 0x60) {
      allocateSpriteSlot(r5, 0x80, 0x80310a4); //TODO
      final GraphicsStruct1c struct = FUN_801eadc(r5, 0x4000_0000, r8, 0, 0);
      MEMORY.ref(4, CPU.sp().value + 0x40).setu(struct.getAddress()); //TODO
      FUN_80b0038(CPU.sp().value + 0x40, 0x8c + r8.x_0c.get() * 0x8, 0x34 + r8.y_0e.get() * 0x8);
    }

    //LAB_8020ce2
    //LAB_8020ce6
    r5 = getFreeVramSlot();
    if(r5 < 0x60) {
      allocateSpriteSlot(r5, 0x80, 0x80317e4); //TODO
      final GraphicsStruct1c struct = FUN_801eadc(r5, 0x4000_0000, r8, 0, 0);
      MEMORY.ref(4, CPU.sp().value + 0x30).setu(struct.getAddress()); //TODO
      struct.z_0f.set(0xff);
      struct.packet_10.attribs_04.attrib2_04.and(~0xc00);
      FUN_80b0038(CPU.sp().value + 0x30, FUN_8020b14(sp18) + 0x46, 0x16);
    }

    //LAB_8020d68
    //LAB_8020d6c
    DMA.channels[3].SAD.setu(0x50001e0);
    DMA.channels[3].DAD.setu(0x50001c0);
    DMA.channels[3].CNT.setu(0x84000008);

    MEMORY.ref(2, 0x50001c8).setu(0x6318);
    int sp08 = sp20 + sp18;

    jmp_8021034:
    {
      //LAB_8020d86
      do {
        if(r6 == 0x12 && (r7 == 0x4 || r7 == 0x5)) {
          r5 = 0x3;
        } else {
          r5 = 0x1;
        }

        //LAB_8020db0
        FUN_8020a60(r8, r6, r7, r5, 0x1, 0xe);
        sleep(0x1);
        FUN_8020a60(r8, r6, r7, r5, 0x1, 0xf);
        if(r9 != 0) {
          r9 = 0;
          FUN_80b0030(CPU.sp().value + 0x40, (r8.x_0c.get() + r6) * 0x8 - 0x7, (r8.y_0e.get() + r7) * 0x8 + 0xf, 0x3);
        }

        //LAB_8020e02
        if(sp0c != 0) {
          sp0c = 0;
          FUN_80b0030(CPU.sp().value + 0x30, FUN_8020b14(sp18) + 0x46, 0x16, 0x3);
        }

        //LAB_8020e20
        FUN_80b0020(CPU.sp().value + 0x40);
        FUN_80b0028(CPU.sp().value + 0x30);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
        r0 = ticks_3001800.get() >>> 1;
        MEMORY.ref(2, r5 + 0x16).and(~0x1ff).or(MEMORY.ref(2, r5 + 0x6).getUnsigned() + MEMORY.ref(1, 0x80371f6 + (r0& 0x7)).get() & 0x1ff);
        MEMORY.ref(1, r5 + 0x14).setu(MEMORY.ref(1, r5 + 0x8).getUnsigned() + MEMORY.ref(1, 0x80371f6 + (r0 + 0x5 & 0x7)).getUnsigned());

        if((pressedButtons_3001b04.get() & 0x40) != 0) {
          playSound_(0x6f);
          r9 = 0x1;
          r7--;
          if(r6 == 0x12) {
            //LAB_8020e9c
            r7 = 0x5 - ((-(0x3 ^ r7) | 0x3 ^ r7) >>> 31);
          } else if(r7 == -1) {
            r7 = 0x5;
          }
        }

        //LAB_8020eaa
        if((pressedButtons_3001b04.get() & 0x80) != 0) {
          playSound_(0x6f);
          r9 = 0x1;
          r7++;
          if(r6 == 0x12) {
            //LAB_8020ecc
            r7 = 0x4 + ((-(0x6 ^ r7) | 0x6 ^ r7) >>> 31);
          } else if(r7 == 0x6) {
            r7 = 0;
          }
        }

        //LAB_8020ed8
        if((pressedButtons_3001b04.get() & 0x20) != 0) {
          playSound_(0x6f);
          r6--;
          r9 = 0x1;
          if(r6 == -1) {
            r3 = r7 - 0x4;
            r6 = 0x12;
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r6 = 0x10;
            }
          } else {
            //LAB_8020f02
            if(r6 == 0x5 || r6 == 0xb || r6 == 0x11) {
              //LAB_8020f0e
              r6--;
            }
          }
        }

        //LAB_8020f12
        if((pressedButtons_3001b04.get() & 0x10) != 0) {
          playSound_(0x6f);
          r6++;
          r9 = 0x1;
          if(r6 == 0x13) {
            r6 = 0;
            //LAB_8020f30
          } else if(r6 == 0x5 || r6 == 0xb || r6 == 0x11) {
            //LAB_8020f3c
            r6++;
          }

          //LAB_8020f3e
          if(r6 == 0x12) {
            r3 = r7 - 0x4;
            CPU.cmpT(r3, 0x1);
            if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
              r6 = 0;
            }
          }
        }

        //LAB_8020f4a
        if((pressedButtons_3001c94.get() & 0x8) != 0) { // Start
          playSound_(0x6f);
          r9 = 0x1;
          r6 = 0x12;
          r7 = 0x5;
        }

        jmp_8020f76:
        {
          //LAB_8020f64
          r5 = pressedButtons_3001b04.get() & 0x2;
          if(r5 == 0) {
            //LAB_8020fa6
            if((pressedButtons_3001b04.get() & 0x1) == 0) {
              continue;
            }

            //LAB_8020fb2
            playSound_(0x70);

            if(r6 != 0x12) {
              //LAB_8020fe6
              r3 = (r8.y_0e.get() + r7 + 1) * 0x20 + r8.x_0c.get() + r6 + 1;
              r3 = MEMORY.ref(1, sp10._00.getAddress() + r3 * 0x2).getUnsigned(); //TODO
              if(sp1c != 0x5) {
                //LAB_8021006
                MEMORY.ref(1, sp08).setu(r3);
                sp08++;
                MEMORY.ref(1, sp08).setu(r5);
                sp1c++;
                if(sp1c == 0x5) {
                  r6 = 0x12;
                  r7 = 0x5;
                  r9 = 0x1;
                }

                //LAB_8021020
                FUN_8016478(sp28);
                FUN_8020b64(sp28, sp18);
                sp0c = 0x1;
              }
              continue;
            }

            if(r7 == 0x5) {
              if(sp1c == 0) {
                //LAB_8020d34
                r2 = MEMORY.ref(4, CPU.sp().value + 0x30).get();
                MEMORY.ref(1, r2 + 0x5).setu(0xd);
                FUN_8016478(sp28);
                FUN_8020b64(sp28, charData.getAddress());
                sleep(0xa);
              } else {
                //LAB_8020fc8
                //LAB_8020fce
                for(r0 = 0; r0 < 15; r0++) {
                  charData.name_00.get(r0).set(MEMORY.ref(1, sp18 + r0).getUnsigned());
                }
              }
              break jmp_8021034;
            }

            //LAB_8020fde
            if(r7 == 0x4) {
              //LAB_8020fe4
              break jmp_8020f76;
            }
            continue;
          }
          playSound_(0x71);
        }

        //LAB_8020f76
        if(sp1c != 0) {
          sp1c--;
          sp08--;
          MEMORY.ref(1, sp08).setu(0);
          FUN_8016478(sp28);
          FUN_8020b64(sp28, sp18);
          sp0c = 0x1;
          continue;
        }

        break;
      } while(true);

      //LAB_8020f9e
      sp24 = -1;
    }

    //LAB_8021034
    FUN_8016418(r8, 0x2);
    FUN_8016418(sp28, 0x2);
    FUN_8019e48(sp2c);
    sleep(0x1);
    CPU.sp().value += 0x60;

    return sp24;
  }

  @Method(0x8021360)
  public static int FUN_8021360(final int charId) {
    if(charId < 0 || charId > 8) {
      return 0;
    }

    if(readFlag_(0x20) == 0) {
      return MEMORY.ref(2, 0x8037206 + charId * 0x2).get();
    }

    //LAB_802137c
    return MEMORY.ref(2, 0x8037216 + charId * 0x2).get();
  }

  @Method(0x8021390)
  public static void FUN_8021390(final int charId) {
    CPU.sp().value -= 0x1c;
    final Struct12fc r5 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    final Panel24 r8 = addPanel(2, 1, 26, 5, 0);
    if(r8 != null) {
      FUN_801e41c(r8, 4, 0, 4, 4);
      r5._ea3.set(1);
      FUN_801a4fc(FUN_8019d2c(FUN_8021360(charId)), 0, CPU.sp().value + 0xc, CPU.sp().value + 0x8, 14, 0);
      final RenderPacket0c r7 = MEMORY.ref(4, CPU.sp().value + 0x10, RenderPacket0c::new);
      r7.next_00.clear();
      r7.attribs_04.y_00.set(12);
      r7.attribs_04.flags_01.set(0);
      r7.attribs_04.attrib2_04.set(0x8014);
      r7.attribs_04.attrib2_04.set(0xe000 | MEMORY.ref(4, CPU.sp().value + 0x8).get());
      r5._12f4.set(0);
      r5._12f6.set(0);
      FUN_8019908(charId, 1);
      FUN_80165d8(r8, FUN_8019ba0(27), 36, 2, 0, 0);
      playSound_(0x51);

      //LAB_802142a
      do {
        insertIntoRenderQueue(r7, 0xfa);
        sleep(1);
      } while(FUN_80f9048() != 0 && (pressedButtons_3001c94.get() & 0x303) == 0);

      //LAB_8021448
      FUN_8016418(r8, 2);
      sleep(1);
      clearVramSlot(MEMORY.ref(4, CPU.sp().value + 0xc).get());
    }

    //LAB_802145c
    CPU.sp().value += 0x1c;
  }

  @Method(0x80215e0)
  public static void FUN_80215e0(final int textureIndex, final int slot) {
    final int dest = mallocSlotBoard(14, 0x400);
    if(slot < 0x60) {
      FUN_80053e8(MEMORY.ref(4, 0x8031864 + textureIndex * 0x4).get(), dest);
      allocateSpriteSlot(slot, 0x200, dest);
      freeSlot(14);
    }

    //LAB_8021614
  }

  @Method(0x8021620)
  public static GraphicsStruct1c FUN_8021620(final int r0, final Panel24 panel, final int x, final int y) {
    final int slot = getFreeVramSlot();

    if(slot >= 0x60) {
      return null;
    }

    FUN_80215e0(r0, slot);
    final GraphicsStruct1c r8 = FUN_801eadc(slot, 0x80004000, panel, x, y);
    r8.z_0f.set(0xfd);

    final GraphicsStruct1c r0_0 = FUN_801eadc(slot, 0x80004000, panel, x + 0x20, y);
    r0_0.z_0f.set(0xfd);

    final int r1_0 = r0_0.packet_10.attribs_04.attrib2_04.get();
    r0_0.packet_10.attribs_04.attrib2_04.set(r1_0 & ~0x3ff | (r1_0 & 0x3ff) + 0x8 & 0x3ff);

    //LAB_80216a0
    return r8;
  }

  @Method(0x80216b4)
  public static void FUN_80216b4(final GraphicsStruct1c r0) {
    r0.packet_10.attribs_04.y_00.set((r0.y_08.get() & 0xff) + MEMORY.ref(1, 0x8037226 + (ticks_3001800.get() >>> 2 & 0x7)).getUnsigned());
    final GraphicsStruct1c r0_0 = r0._00.deref();
    r0_0.packet_10.attribs_04.y_00.set((r0.y_08.get() & 0xff) + MEMORY.ref(1, 0x8037226 + (ticks_3001800.get() >>> 2 & 0x7)).getUnsigned());
  }

  @Method(0x80216e8)
  public static void FUN_80216e8(final int r0, final int r1, final int r2) {
    final int r5 = mallocSlotBoard(14, 0x400);
    final int r2_0 = getPointerTableEntry(241);
    if(r1 < 0x60) {
      FUN_80053e8(r2_0 + MEMORY.ref(2, r2_0 + r0 * 0x2).getUnsigned(), r5);

      if(r2 != 0) {
        FUN_8009288(r5, 0x300);
      }

      //LAB_802172e
      allocateSpriteSlot(r1, 0x400, r5);
      freeSlot(14);
    }

    //LAB_802173e
  }

  @Nullable
  @Method(0x8021750)
  public static GraphicsStruct1c FUN_8021750(final int r0, final int r1, final Panel24 r2, final int r3, final int a4) {
    final int r5 = getFreeVramSlot();

    if(r5 == 0x60) {
      return null;
    }

    FUN_80216e8(r0, r5, r1);
    final GraphicsStruct1c r0_0 = FUN_801eadc(r5, 0x80000000, r2, r3, a4);
    r0_0.z_0f.set(0xfb);
    r0_0.packet_10.attribs_04.flags_01.or(0x20);

    //LAB_8021796
    return r0_0;
  }

  @Method(0x80217a4)
  public static void FUN_80217a4(final int r0) {
    if(r0 != 0) {
      final int r1 = MEMORY.ref(4, 0x8037230 + (ticks_3001800.get() >>> 1 & 0x7) * 0x4).get() / 0x100;

      CPU.sp().value -= 0x8;
      MEMORY.ref(2, CPU.sp().value).setu(r1 & 0xffff);
      MEMORY.ref(2, CPU.sp().value + 0x2).setu(r1 & 0xffff);
      MEMORY.ref(2, CPU.sp().value + 0x4).set(0);
      MEMORY.ref(1, r0 + 0x17).and(~0x3e).or((addRotScaleParams(CPU.sp().value) & 0x1f) << 1);
      CPU.sp().value += 0x8;

      MEMORY.ref(1, r0 + 0x15).oru(0x3);
      MEMORY.ref(2, r0 + 0x16).and(~0x1ff).or(MEMORY.ref(2, r0 + 0x6).getUnsigned() + 0xfff0 & 0x1ff);
      MEMORY.ref(1, r0 + 0x14).setu(MEMORY.ref(1, r0 + 0x8).getUnsigned() + 0xf0);
      MEMORY.ref(1, r0 + 0xf).setu(0xfc);
    }

    //LAB_8021840
  }

  @Method(0x8021848)
  public static void FUN_8021848() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    r7 = 0x0;

    //LAB_802185a
    do {
      r3 = r7 << 1;
      r3 = r3 + r7;
      r2 = 0x6006280;
      r3 = r3 << 7;
      r6 = 0x0;
      r5 = r3 + r2;

      //LAB_8021866
      do {
        r0 = r5;
        r1 = 0x40;
        r2 = 0x44444444;
        MEMORY.call(0x3000168, r0, r1, r2); // memfill32
        r4 = 0x1;
        r0 = r5 + 0x4;

        //LAB_8021874
        do {
          r1 = r6;
          if(r7 != 0x1 || r4 > 0x1) {
            //LAB_802187e
            if(r7 == 0x0) {
              r3 = r4 - 0x2;
              if(r6 > r3) {
                r1 = r3;
                if(r1 < 0x0) {
                  r1 = 0x0;
                }
              }
            }

            //LAB_8021890
            r1 = r1 << 3;
            r3 = MEMORY.ref(4, 0x8037250 + r1).get();
            r2 = MEMORY.ref(4, r0).get();
            r2 = r2 ^ r3;
            MEMORY.ref(4, r0).setu(r2);
            r1 = r1 + 0x4;
            r2 = MEMORY.ref(4, r0 + 0x20).get();
            r1 = MEMORY.ref(4, 0x8037250 + r1).get();
            r2 = r2 ^ r1;
            MEMORY.ref(4, r0 + 0x20).setu(r2);
          }

          //LAB_80218a8
          r4 = r4 + 0x1;
          r0 = r0 + 0x4;
        } while(r4 <= 0x7);

        r6 = r6 + 0x1;
        r5 = r5 + 0x40;
      } while(r6 <= 0x5);

      r7 = r7 + 0x1;
    } while(r7 <= 0x1);
  }

  @Method(0x8021950)
  public static void FUN_8021950(int r0, int r1, int r2, int r3) {
    final int r6 = r3;
    r3 = -r6;
    int sp04 = r0;
    int r7 = r2;
    int sp00 = r1;
    final int r8 = r3 * 0x4;
    final int lr = r6 * 0x4;

    //LAB_802196e
    for(int r12 = 0; r12 < 8; r12++) {
      int r4 = MEMORY.ref(4, sp00).get();
      sp00 += 0x4;

      r1 = MEMORY.ref(4, sp04).get();
      sp04 += 0x4;

      r2 = 0;
      if(r6 < 0) {
        r4 = r4 >>> r8;
      } else {
        //LAB_802198a
        r4 = r4 << lr;
      }

      //LAB_802198e
      //LAB_8021992
      for(r0 = 0; r0 < 8; r0++) {
        r2 = r2 << 4;
        r4 = CPU.cmpT(r4, 0xfffffff);
        if(CPU.cpsr().getCarry() && !CPU.cpsr().getZero()) { // unsigned >
          r3 = r4 >>> 28;
        } else {
          //LAB_802199c
          r3 = r1 >>> 28;
        }

        //LAB_802199e
        r2 = r2 + r3;
        r4 = r4 << 4;
        r1 = r1 << 4;
      }

      MEMORY.ref(4, r7).setu(r2);
      r7 += 0x4;
    }
  }

  @Method(0x80219c8)
  public static void FUN_80219c8(final int r0) {
    final int r6 = MathHelper.clamp(_3001e40.get() >>> 2 & 0x3, 1, 2) + 1;
    FUN_8021950(0x6000220, 0x8037280, r0, -r6);
    FUN_8021950(0x6000240, 0x80372a0, r0 + 0x20, r6);
  }

  @Method(0x8021a18)
  public static void FUN_8021a18(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r11().value);
    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r2 = 0x0;
    CPU.r9().value = r0;
    CPU.r10().value = r2;
    CPU.r8().value = r2;
    CPU.r11().value = r2;

    //LAB_8021a30
    do {
      r3 = 0x0;
      CPU.lr().value = r3;
      r3 = CPU.r11().value;
      r3 = r3 + CPU.r10().value;
      r7 = r3 << 6;

      //LAB_8021a3a
      do {
        r2 = CPU.r9().value;
        r6 = r2 + r7;
        r2 = CPU.lr().value;
        r3 = r2 << 5;
        r2 = 0x6000600;
        r5 = r3 + r2;
        r3 = 0x0;
        CPU.r12().value = r3;

        //LAB_8021a4a
        do {
          r1 = MEMORY.ref(2, r5).getUnsigned();
          r0 = 0x0;
          r5 = r5 + 0x2;
          r4 = 0x0;

          //LAB_8021a52
          do {
            r3 = r1;
            r2 = 0xf;
            r3 = r3 & r2;
            r3 = r3 + CPU.r8().value;
            r2 = r3 << 1;
            r3 = 0x80372c0;
            r2 = MEMORY.ref(2, r3 + r2).getUnsigned();
            r3 = r4 << 2;
            r2 = r2 << r3;
            r4 = r4 + 0x1;
            r1 = r1 >>> 4;
            r0 = r0 | r2;
          } while(r4 <= 0x3);

          r2 = 0x1;
          CPU.r12().value = CPU.r12().value + r2;
          r3 = CPU.r12().value;
          MEMORY.ref(2, r6).setu(r0);
          r6 = r6 + 0x2;
        } while(r3 <= 0xf);

        CPU.lr().value = CPU.lr().value + r2;
        r2 = CPU.lr().value;
        r7 = r7 + 0x20;
      } while(r2 <= 0x9);

      r3 = 0x10;
      CPU.r8().value = CPU.r8().value + r3;
      r3 = 0x1;
      r2 = 0x4;
      CPU.r10().value = CPU.r10().value + r3;
      CPU.r11().value = CPU.r11().value + r2;
      r2 = CPU.r10().value;
    } while(r2 <= 0x1);

    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    CPU.r11().value = CPU.pop();
  }

  @Method(0x8021af0)
  public static int FUN_8021af0(final int r0, final int r1) {
    final int addr = mallocSlotBoard(17, 0x608);
    FUN_801a088(r0, 26);
    final int ret = FUN_80040d0(r1, addr + 0x400);
    freeSlot(17);
    return ret;
  }

  @Method(0x8021b30)
  public static int FUN_8021b30(final int r0, final int r1) {
    final int addr = mallocSlotBoard(17, 0x608);

    CPU.sp().value -= 0xc;
    MEMORY.ref(4, CPU.sp().value + 0x8).setu(r1);
    FUN_801a3d0(r0, 0, CPU.sp().value + 0x8, CPU.sp().value + 0x4, 1);
    CPU.sp().value += 0xc;

    final int ret = FUN_80040d0(r1, addr + 0x400);
    freeSlot(17);
    return ret;
  }

  @Method(0x8021b80)
  public static int FUN_8021b80(int r0, final int r1) {
    int r5;

    CPU.sp().value -= 0x10;
    r5 = r0;
    MEMORY.ref(4, CPU.sp().value + 0xc).setu(r1);
    if((r5 & 0xffff_ffffL) > 7) {
      r5 = 0x0;
    }

    //LAB_8021b8e
    if(readFlag_(0x20) != 0) {
      if(r5 == 0) {
        //LAB_8021ba2
        r5 = 0x38;
      } else if(r5 == 1) {
        //LAB_8021ba6
        r5 = 0x39;
      }
    }

    //LAB_8021ba8
    FUN_801a4fc(r5, 0, CPU.sp().value + 0xc, CPU.sp().value + 0x8, 14, 1);
    r0 = MEMORY.ref(4, CPU.sp().value + 0x8).get();
    CPU.sp().value += 0x10;
    return r0;
  }


  @Method(0x8021bc8)
  public static int FUN_8021bc8(int r0) {
    if(r0 != 0) {
      r0 = 0;
    }

    //LAB_8021bd0
    return MEMORY.ref(4, 0x8073968 + r0 * 0x4).get();
  }

  @Method(0x8021c34)
  public static Panel24 FUN_8021c34() {
    final Panel24 r5 = addPanel(0, 0, 6, 4, 6);
    FUN_801e940(0x8037300, r5, 0, 0);
    return r5;
  }

  @Method(0x8021c64)
  public static int FUN_8021c64(final int r0, final int r1) {
    final int r6 = mallocSlotChip(17, 0x608);
    final int ptr = getPointerTableEntry(0xf1);
    MEMORY.ref(4, r6 + 0x604).setu(ptr + MEMORY.ref(2, ptr + r1 * 0x2).getUnsigned());
    FUN_80053e8(MEMORY.ref(4, r6 + 0x604).get(), r6);
    final int r5 = FUN_80040d0(r0, r6);
    freeSlot(17);
    return r5;
  }

  @Method(0x8021cb8)
  public static void FUN_8021cb8(final int r0, final int r1, final int r2) {
    final int r6 = mallocSlotChip(17, 0x608);
    final int ptr = getPointerTableEntry(241);
    MEMORY.ref(4, r6 + 0x604).setu(ptr + MEMORY.ref(2, ptr + r1 * 0x2).getUnsigned());
    FUN_80053e8(MEMORY.ref(4, r6 + 0x604).get(), r6);
    final int lr = mallocChip(0x400);

    //LAB_8021cfa
    for(int r12 = 0; r12 < 0x400; r12++) {
      final int r4 = MEMORY.ref(1, r6 + r12).getUnsigned();
      int r2_0 = MEMORY.ref(1, r0 + r4).getUnsigned();
      if(r2_0 == 0xff) {
        final int r3 = MEMORY.ref(4, r0 + 0x100).get();
        MEMORY.ref(1, r0 + r4).setu(r3);
        if(r3 < 0x40) {
          MEMORY.ref(2, 0x5000000 + r3 * 0x2).setu(MEMORY.ref(2, 0x5000200 + r4 * 0x2).getUnsigned());
          MEMORY.ref(4, r0 + 0x100).incr();
          r2_0 = MEMORY.ref(1, r0 + r4).getUnsigned();
        } else {
          //LAB_8021d34
          r2_0 = r3;
        }
      }

      //LAB_8021d36
      MEMORY.ref(1, lr + r12).setu(r2_0);
    }

    DMA.channels[3].SAD.setu(lr);
    DMA.channels[3].DAD.setu(0x6004000 + r2 * 0x40);
    DMA.channels[3].CNT.setu(0x84000100);
    setMallocAddress(lr);
    freeSlot(17);
  }

  @Method(0x8021d88)
  public static void FUN_8021d88(final int r0, final int r1, final int r2) {
    FUN_8021cb8(r0, r2, r1 * 16);
    MEMORY.ref(4, r0 + 0x11c + r1 * 0x1c).setu(r2);
    MEMORY.ref(4, r0 + 0x104 + r1 * 0x1c + 0x4).setu(0x80002000);
    MEMORY.ref(4, r0 + 0x104 + r1 * 0x1c + 0x8).setu(0);
    MEMORY.ref(2, r0 + 0x104 + r1 * 0x1c + 0x8).and(~0x3ff).or(FUN_8021c64(MEMORY.ref(2, r0 + 0x110 + r1 * 0x1c).getUnsigned(), r2) & 0x3ff);
  }

  @Method(0x8021dfc)
  public static void FUN_8021dfc() {
    GPU.BG1CNT.and(~0x3).or(0x3);
  }

  @Method(0x8021e14)
  public static void FUN_8021e14() {
    GPU.BG1CNT.and(~0x3);
  }

  @Method(0x8021e48)
  public static Panel24 FUN_8021e48(final int r0, final int r1, final int r2) {
    final Panel24 r5 = FUN_8017658(r0, r1, r2, 1);

    //LAB_8021e5a
    while(FUN_8017364() == 0) {
      //LAB_8021e54
      sleep(1);
    }

    return r5;
  }

  @Method(0x8021e6c)
  public static int FUN_8021e6c(int r0) {
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    final int r9;
    int r10;
    int r11;

    CPU.sp().value -= 0x3c;
    final int sp34 = r0;
    final Struct12fc sp30 = boardWramMallocHead_3001e50.offset(15 * 0x4).deref(4).cast(Struct12fc::new);
    r7 = allocateFirstFreeSpriteSlot(0x400);
    int sp2c = 1;
    int sp28 = 0;
    r9 = mallocBoard(0x1e0);

    //LAB_8021ea8
    MEMORY.memfill(r9, 0x100, 0xff);

    MEMORY.ref(4, r9 + 0x100).setu(1);
    if(sp34 == 0) {
      MEMORY.ref(4, r9 + 0x1ac).setu(addPanel(20, 17, 10, 3, 6).getAddress());
    } else {
      //LAB_8021ece
      MEMORY.ref(4, r9 + 0x1ac).setu(addPanel(22, 17, 8, 3, 6).getAddress());
    }

    //LAB_8021eda
    MEMORY.ref(4, r9 + 0x1c4).setu(-1);

    if(sp34 == 0) {
      MEMORY.ref(4, r9 + 0x1c8).setu(14);
      MEMORY.ref(4, r9 + 0x1cc).setu(4);
      MEMORY.ref(4, r9 + 0x1d0).setu(7);
      MEMORY.ref(4, r9 + 0x1d4).setu(-1);
      r3 = boardWramMallocHead_3001e50.offset(57 * 0x4).get();
      MEMORY.ref(4, r9 + 0x1c0).setu(MEMORY.ref(4, r3 + 0x3c).get());
    } else {
      //LAB_8021f6c
      r3 = boardWramMallocHead_3001e50.offset(57 * 0x4).get();
      MEMORY.ref(4, r9 + 0x1c0).setu(MEMORY.ref(4, r3 + 0x40).get());
      MEMORY.ref(4, r9 + 0x1c8).setu(0);
      MEMORY.ref(4, r9 + 0x1cc).setu(1);
      r5 = 2;
      if(getDjinnRecoveryQueue_(0)._00.get() != 0) {
        r5 = CPU.sp().value + 0x38;
        FUN_80b5130(0, r5);

        //LAB_8021fa6
        for(int i = 0; i < 4; i++) {
          sp28 += MEMORY.ref(1, r5 + i).getUnsigned();
        }

        MEMORY.ref(4, r9 + 0x1d0).setu(15);
        r5 = 3;
        if(sp28 != 0) {
          MEMORY.ref(4, r9 + 0x1d4).setu(16);
          r5 = 4;
        }
      }

      //LAB_8021fce
      MEMORY.ref(4, r9 + 0x1c8 + r5 * 0x4).setu(2);
      MEMORY.ref(4, r9 + 0x1c8 + (r5 + 1) * 0x4).setu(3);
      MEMORY.ref(4, r9 + 0x1c8 + (r5 + 2) * 0x4).setu(-1);
    }

    //LAB_8021ff0
    //LAB_8022018
    for(r8 = 0; r8 < 6 && (r2 = MEMORY.ref(4, r9 + 0x1c8 + r8 * 0x4).get()) != -1; r8++) {
      MEMORY.ref(2, r9 + 0x110 + r8 * 0x1c).setu(r7);
      FUN_8021d88(r9, r8, r2);
    }

    //LAB_8022038
    MEMORY.ref(4, r9 + 0x1b0).setu(r8);
    MEMORY.ref(2, r9 + 0x1b4).setu(0x140);
    MEMORY.ref(2, r9 + 0x1b6).setu(0x130);
    MEMORY.ref(2, r9 + 0x1b8).setu(0);

    //LAB_8022076
    for(r8 = 0; r8 < MEMORY.ref(4, r9 + 0x1b0).get(); r8++) {
      r2 = (r8 - MEMORY.ref(4, r9 + 0x1b0).get()) * 0x18;

      if(sp34 == 0) {
        MEMORY.ref(4, r9 + 0x114 + r8 * 0x1c).setu(r2 + 0x9b);
      } else {
        MEMORY.ref(4, r9 + 0x114 + r8 * 0x1c).setu(r2 + 0xab);
      }

      //LAB_8022096
      MEMORY.ref(4, r9 + 0x118 + r8 * 0x1c).setu(0x88);
    }

    //LAB_80220a6
    setTickCallback(getRunnable(GoldenSun_802.class, "FUN_8021dfc"), 0x480);
    setInterruptHandler(2, 136, getRunnable(GoldenSun_802.class, "FUN_8021e14"));

    //LAB_80220ce
    do {
      r1 = MEMORY.ref(2, 0x80366f8 + (_3001e40.get() * 2 & 0x1f) * 0x2).getUnsigned();
      final int sp24 = (r1 - 0x100) / 4 + 0x130;
      MEMORY.ref(2, r9 + 0x1b4).setu(sp24);
      MEMORY.ref(2, r9 + 0x1b6).setu(sp24);
      r2 = 0x3001ad0;
      MEMORY.ref(2, r2 + 0x4).setu(0);
      MEMORY.ref(2, r2 + 0x6).setu(32);
      if(sp2c != 0) {
        //LAB_802211e
        sp2c = 0;
        sp30._ea6.set(1);
        if(sp34 != 0) {
          //LAB_8022134
          CPU.lr().value = 0;
          r3 = 6 - MEMORY.ref(4, r9 + 0x1b0).get();
          if(CPU.lr().value < r3) {
            CPU.r12().value = 6 - MEMORY.ref(4, r9 + 0x1b0).get();
            r4 = 0x0;

            //LAB_802217e
            do {
              r3 = r4 + CPU.lr().value;
              r0 = sp30._00.getAddress() + r3 * 0x2;
              r8 = 0;

              //LAB_802218c
              do {
                r2 = 0;
                r1 = r0;

                //LAB_8022198
                do {
                  MEMORY.ref(2, r1 + 0x448 + (r2 & 0x3) * 0x2).setu(0xf07f);
                  r2++;
                } while(r2 < 3);

                r0 += 0x40;
                r8++;
              } while(r8 < 3);

              r4 += 0x2;
              CPU.lr().value++;
            } while(CPU.lr().value < CPU.r12().value);
          }

          //LAB_80221c2
          CPU.lr().value = 0;
          if(CPU.lr().value < MEMORY.ref(4, r9 + 0x1b0).get()) {
            //LAB_80221d0
            r11 = MEMORY.ref(4, r9 + 0x1b0).get();
            r10 = r11 * 3;
            final int sp20 = r10 * 2;
            int sp08 = 0;

            //LAB_80221ea
            do {
              r2 = sp08 + CPU.lr().value;
              r1 = CPU.lr().value;
              r8 = 0;
              r4 = sp30._00.getAddress() + r2 * 0x2;
              r6 = r2;
              r5 = r1 << 4;

              //LAB_80221fe
              do {
                final int sp04 = r5;
                r0 = 0x0;
                CPU.r12().value = r6;

                //LAB_8022204
                do {
                  r1 = r0 & 0x3;
                  r3 = CPU.r12().value;
                  r2 = r3 + r1;
                  r7 = r10;
                  r2 = r2 - r7;
                  r3 = 0x600fd6c;
                  r2 = r2 << 1;
                  r2 = r2 + r3;
                  r3 = sp04 + r0;
                  r3 = r3 + 0x100;
                  MEMORY.ref(2, r2).setu(r3);
                  r1 = r1 << 1;
                  r1 = r4 + r1;
                  r1 = r1 - sp20;
                  r1 = r1 + 0x46c;
                  r0 = r0 + 0x1;
                  MEMORY.ref(2, r1).setu(0);
                } while(r0 < 3);

                r4 = r4 + 0x40;
                r6 = r6 + 0x20;
                r5 = r5 + 0x4;
                r8++;
              } while(r8 < 3);

              sp08 += 0x2;
              CPU.lr().value++;
            } while(CPU.lr().value < r11);
          }
        } else {
          //LAB_8022264
          CPU.lr().value = 0;
          r3 = MEMORY.ref(4, r9 + 0x1b0).get();
          r2 = 0x6;
          r3 = r2 - r3;
          if(CPU.lr().value < r3) {
            r3 = MEMORY.ref(4, r9 + 0x1b0).get();
            r2 = r2 - r3;
            CPU.r12().value = r2;
            r4 = 0x0;

            //LAB_8022286
            do {
              r5 = 0x0;
              r8 = r5;
              r0 = sp30._00.getAddress() + (r4 + CPU.lr().value) * 0x2;

              //LAB_8022294
              do {
                r2 = 0x0;
                r1 = r0;

                //LAB_8022298
                do {
                  r3 = r2;
                  r3 = r3 & 0x3;
                  r3 = r3 << 1;
                  r5 = 0x444;
                  r3 = r3 + r1;
                  r3 = r3 + r5;
                  r2 = r2 + 0x1;
                  MEMORY.ref(2, r3).setu(0xf07f);
                } while(r2 <= 0x2);

                r0 += 0x40;
                r8++;
              } while(r8 < 3);

              r4 += 0x2;
              CPU.lr().value++;
            } while(CPU.lr().value < CPU.r12().value);
          }

          //LAB_80222cc
          CPU.lr().value = 0;
          if(CPU.lr().value < MEMORY.ref(4, r9 + 0x1b0).get()) {
            r11 = MEMORY.ref(4, r9 + 0x1b0).get();
            r10 = r11 * 3;
            final int sp1c = r10 * 2;
            int sp0c = 0;

            //LAB_80222f2
            do {
              r2 = sp0c + CPU.lr().value;
              r1 = CPU.lr().value;
              r8 = 0;
              r4 = sp30._00.getAddress() + r2 * 0x2;
              r6 = r2;
              r5 = r1 << 4;

              //LAB_8022306
              do {
                final int sp04 = r5;
                r0 = 0x0;
                CPU.r12().value = r6;

                //LAB_802230c
                do {
                  r1 = r0;
                  r1 = r1 & 0x3;
                  r3 = CPU.r12().value;
                  r2 = r3 + r1;
                  r2 = r2 - r10;
                  r3 = 0x600fd68;
                  r2 = r2 << 1;
                  r2 = r2 + r3;
                  r3 = sp04 + r0;
                  r3 = r3 + 0x100;
                  MEMORY.ref(2, r2).setu(r3);
                  r1 = r1 << 1;
                  r1 = r4 + r1;
                  r1 = r1 - sp1c;
                  r1 = r1 + 0x468;
                  r0 = r0 + 0x1;
                  MEMORY.ref(2, r1).setu(0);
                } while(r0 <= 0x2);

                r4 = r4 + 0x40;
                r6 = r6 + 0x20;
                r5 = r5 + 0x4;
                r8++;
              } while(r8 <= 0x2);

              sp0c += 0x2;
              CPU.lr().value++;
            } while(CPU.lr().value < r11);
          }
        }
      }

      //LAB_802236c
      if(MEMORY.ref(4, r9 + 0x1c4).get() != MEMORY.ref(4, r9 + 0x1c0).get()) {
        FUN_8016478(MEMORY.ref(4, r9 + 0x1ac).deref(4).cast(Panel24::new));
        r2 = MEMORY.ref(4, r9 + 0x1c0).get();
        FUN_801e7c0(MEMORY.ref(4, r9 + 0x11c + r2 * 0x1c).get() + 0x1f, MEMORY.ref(4, r9 + 0x1ac).deref(4).cast(Panel24::new), 0, 0);
        MEMORY.ref(4, r9 + 0x1c4).setu(MEMORY.ref(4, r9 + 0x1c0).get());
        r1 = MEMORY.ref(4, r9 + 0x1c0).get();
        FUN_8021d88(r9, r1, MEMORY.ref(4, r9 + 0x1c8 + r1 * 0x4).get());
      }

      //LAB_80223c4
      MEMORY.ref(4, r9 + 0x1bc).setu(addRotScaleParams(r9 + 0x1b4));

      //LAB_80223fc
      for(r8 = 0; r8 < MEMORY.ref(4, r9 + 0x1b0).get(); r8++) {
        r5 = r9 + 0x104 + r8 * 0x1c;
        r3 = MEMORY.ref(4, r9 + 0x1c0).get();
        if(r8 == r3) {
          r2 = MEMORY.ref(1, r9 + 0x1bc).getUnsigned();
          r3 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
          r2 = r2 & 0x1f;
          r2 = r2 << 1;
          r3 = r3 & ~0x3e;
          r3 = r3 | r2;
          MEMORY.ref(1, r5 + 0x7).setu(r3);
          MEMORY.ref(1, r5 + 0x5).or(0x3);
          r2 = sp24 * 7;
          r1 = MEMORY.ref(4, r5 + 0x10).get();
          if(r2 < 0) {
            r3 = 0x1ff;
            r2 = r2 + r3;
          }

          //LAB_8022432
          r2 = r2 >> 9;
          r2 = r1 + r2;
          r2 = r2 - 0xe;
          r2 = r2 & 0x1ff;
          r3 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
          r3 = r3 & ~0x1ff | r2;
          MEMORY.ref(2, r5 + 0x6).setu(r3);
          r3 = sp24 * 3;
          r2 = MEMORY.ref(4, r5 + 0x14).get();
          if(r3 < 0) {
            r3 = r3 + 0xff;
          }

          //LAB_8022452
          r3 = r3 >> 8;
          r3 = r2 + r3;
          r3 = r3 - 0x14;
          MEMORY.ref(1, r5 + 0x4).setu(r3);
          insertIntoRenderQueue(MEMORY.ref(4, r5, RenderPacket0c::new), 241);
        } else {
          //LAB_802246c
          r2 = MEMORY.ref(4, r5 + 0x10).get();
          r2 = r2 & 0x1ff;
          r3 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
          r3 = r3 & ~0x1ff | r2;
          MEMORY.ref(2, r5 + 0x6).setu(r3);
          r3 = MEMORY.ref(4, r5 + 0x14).get();
          MEMORY.ref(1, r5 + 0x4).setu(r3);
          r3 = MEMORY.ref(1, r5 + 0x7).getUnsigned();
          r0 = 0x4;
          r3 = r3 & ~0x3e;
          MEMORY.ref(1, r5 + 0x7).setu(r3);
          r0 = -r0;
          r3 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
          r2 = r0;
          r3 = r3 & r2;
          MEMORY.ref(1, r5 + 0x5).setu(r3);
        }

        //LAB_8022490
      }

      //LAB_802249e
      r3 = 0x3001c94;
      r2 = 0x3001f34;
      r5 = MEMORY.ref(4, r3).get();
      r3 = 0x3001b04;
      r2 = MEMORY.ref(4, r2).get();
      r7 = MEMORY.ref(4, r3).get();
      r3 = 0xd8;
      r3 = r3 + r2;
      r1 = MEMORY.ref(4, r3).get();
      r8 = r3;
      if(r1 != 0) {
        r6 = r2 + 0xdc;
        r3 = MEMORY.ref(4, r6).get();
        r7 = 0x0;
        r5 = 0x0;
        if(r3 == 0) {
          r3 = MEMORY.ref(4, r2 + 0xe0).get();
          if(r3 == 1) {
            r3 = MEMORY.ref(4, r9 + 0x1c0).get();
            if(MEMORY.ref(4, r9 + 0x1c8 + r3 * 0x4).get() == 0x3) {
              r7 = 0x1;
              r5 = 0x1;
            } else {
              //LAB_80224f4
              r7 = 0x20;
              r5 = 0x20;
            }

            //LAB_80224f8
            MEMORY.ref(4, r6).setu(30);
            //LAB_80224fc
          } else if(r3 == 0) {
            r3 = MEMORY.ref(4, r9 + 0x1c0).get();
            r3 = MEMORY.ref(4, r9 + 0x1c8 + r3 * 0x4).get();
            if(r3 == 0x10 || sp28 == 0 && r3 == 0xf) {
              //LAB_802251e
              if(r1 == 0x1) {
                if(r3 == 0xf) {
                  r0 = 0xc4a;
                  //LAB_802252a
                } else {
                  r0 = 0xc49;
                }
                r1 = 0xf;
                r2 = 0x8;
                final Panel24 sp14 = FUN_8021e48(r0, r1, r2);

                //LAB_802253a
                r1 = 0x9b;
                r0 = 0x66;
                FUN_80b5128(r0, r1);
                FUN_8016418(sp14, 1);
                MEMORY.ref(4, r8).incr();
                r3 = 0x2d;
              } else {
                //LAB_8022556
                r3 = 0xc8;
                r7 = 0x1;
                r5 = 0x1;
              }
            } else {
              //LAB_802255e
              r3 = 0x28;
              r7 = 0x10;
              r5 = 0x10;
            }
            MEMORY.ref(4, r6).setu(r3);
          } else {
            //LAB_8022566
            MEMORY.ref(4, r6).setu(60);
            r7 = 0x1;
            r5 = 0x1;
          }
        } else {
          //LAB_8022570
          r3 = r3 - 0x1;
          MEMORY.ref(4, r6).setu(r3);
        }
      }

      //LAB_8022574
      if((r5 & 0x300) != 0 && sp34 != 0) {
        //LAB_8021f24
        r10 = -2;
        r2 = 0x3001f34;
        break;
      }

      //LAB_8022586
      if((r5 & 0x1) != 0) {
        //LAB_8021f2e
        r3 = MEMORY.ref(4, r9 + 0x1c0).get();
        r10 = MEMORY.ref(4, r9 + 0x1c8 + r3 * 0x4).get();
        r2 = 0x3001f34;
        break;
      }

      //LAB_8022590
      if(sp34 != 0 && (r5 & 0x2) != 0) {
        //LAB_8021f48
        playSound_(0x71);
        r10 = -1;
        r2 = 0x3001f34;
        break;
      }

      //LAB_80225a0
      if((r7 & 0x90) != 0) {
        playSound_(0x6f);
        MEMORY.ref(4, r9 + 0x1c0).setu(modS(MEMORY.ref(4, r9 + 0x1c0).get() + 1, MEMORY.ref(4, r9 + 0x1b0).get()));
        //LAB_80225c2
      } else if((r7 & 0x60) != 0) {
        playSound_(0x6f);
        MEMORY.ref(4, r9 + 0x1c0).setu(modS(MEMORY.ref(4, r9 + 0x1c0).get() + MEMORY.ref(4, r9 + 0x1b0).get() - 1, MEMORY.ref(4, r9 + 0x1b0).get()));
      } else {
        //LAB_80225e4
        r2 = 0x3001f34;
        r3 = MEMORY.ref(4, r2).get();
        r3 = MEMORY.ref(4, r3 + 0x4c).get();
        if(r3 == 0) {
          //LAB_8021f58
          r10 = MEMORY.ref(4, r9 + 0x1c8).get();
          break;
        }
      }

      //LAB_80225f0
      FUN_800387c(0x4000000, 0x1741);
      sp30._ea6.set(0);
      sleep(1);
    } while(true);

    //LAB_802260c
    if(sp34 != 0) {
      r3 = MEMORY.ref(4, r2).get();
      MEMORY.ref(4, r3 + 0x40).setu(MEMORY.ref(4, r9 + 0x1c0).get());
    } else {
      //LAB_8022620
      r3 = MEMORY.ref(4, r2).get();
      MEMORY.ref(4, r3 + 0x3c).setu(MEMORY.ref(4, r9 + 0x1c0).get());
    }

    //LAB_802262c
    //LAB_8022648
    for(r8 = 0; r8 < MEMORY.ref(4, r9 + 0x1b0).get(); r8++) {
      clearVramSlot(MEMORY.ref(2, r9 + 0x110 + r8 * 0x1c).getUnsigned());
    }

    //LAB_802265a
    sp30._ea6.set(1);
    FUN_8016418(MEMORY.ref(4, r9 + 0x1ac).deref(4).cast(Panel24::new), 1);
    r4 = 0x0;
    r5 = 0x0;

    //LAB_8022680
    do {
      r8 = 0;
      r1 = sp30._00.getAddress() + (r5 + r4) * 0x2;

      //LAB_802268c
      do {
        r2 = 0x0;
        r0 = r1;

        //LAB_8022690
        do {
          r3 = r2 & 0x3;
          r3 = r3 << 1;
          r3 = r3 + r0;
          r3 = r3 + 0x44a;
          r2 = r2 + 0x1;
          MEMORY.ref(2, r3).setu(0xf07f);
        } while(r2 < 3);

        r1 += 0x40;
        r8++;
      } while(r8 < 3);

      r5 += 0x2;
      r4++;
    } while(r4 < 7);

    sp30._ea3.set(1);
    sleep(1);
    clearTickCallback(getRunnable(GoldenSun_802.class, "FUN_8021dfc"));
    setInterruptHandler(2, 0, null);
    r1 = 0x2002090;
    r4 = INTERRUPTS.INT_MASTER_ENABLE.getUnsigned();
    INTERRUPTS.INT_MASTER_ENABLE.setu(0x208);
    r2 = MEMORY.ref(2, r1).getUnsigned();
    if(r2 <= 0x1f) {
      r3 = r1 + r2 * 0xc;
      r3 = r3 + 0x4;
      MEMORY.ref(4, r3).setu(0x1541);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(0x4000000);
      r3 += 0x4;
      MEMORY.ref(4, r3).setu(0x20000);
      MEMORY.ref(2, r1).setu(r2 + 0x1);
    }

    //LAB_8022706
    INTERRUPTS.INT_MASTER_ENABLE.setu(r4);
    setMallocAddress(r9);
    sp30._ea6.set(0);
    sleep(1);
    CPU.sp().value += 0x3c;
    return r10;
  }

  @Method(0x8022768)
  public static void FUN_8022768(int r0, int r1, int r2, int r3, final int a4) {
    int r4;
    int r5;
    int r6;
    int r7;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    r4 = r0;
    r0 = r3;
    r3 = 0x3001e8c;
    r7 = r2;
    r3 = MEMORY.ref(4, r3).get();
    CPU.r12().value = a4;
    r5 = CPU.r12().value;
    CPU.r8().value = r3;
    r3 = 0x1;
    r5 = r5 & r3;
    r5 = r5 << 12;
    CPU.r12().value = r5;
    if(r4 < 0) {
      r7 = r7 + r4;
      r4 = 0x0;
    }

    //LAB_8022794
    r3 = r4 + r7;
    if(r3 > 0x1d) {
      r3 = 0x1e;
      r7 = r3 - r4;
    }

    //LAB_802279e
    if(r1 < 0) {
      r0 = r0 + r1;
      r1 = 0x0;
    }

    //LAB_80227a6
    r3 = r1 + r0;
    if(r3 > 0x1d) {
      r3 = 0x14;
      r0 = r3 - r1;
    }

    //LAB_80227b0
    if(r7 > 0 && r0 > 0) {
      r2 = 0xea3;
      r2 = r2 + CPU.r8().value;
      r3 = r4 << 1;
      CPU.lr().value = r2;
      r2 = r1 << 6;
      r6 = r2 + r3;
      r3 = 0x2;
      CPU.r10().value = r3;

      //LAB_80227c8
      do {
        r5 = CPU.r8().value;
        r2 = r7;
        r4 = r6 + r5;
        if(r2 != 0) {
          r3 = 0xffffefff;
          CPU.r9().value = r3;

          //LAB_80227d6
          do {
            r3 = MEMORY.ref(2, r4).getUnsigned();
            r5 = CPU.r9().value;
            r3 = r3 & r5;
            r5 = CPU.r12().value;
            r3 = r3 | r5;
            r2 = r2 - 0x1;
            MEMORY.ref(2, r4).setu(r3);
            r4 = r4 + 0x2;
          } while(r2 != 0);
        }

        //LAB_80227ea
        r3 = r1 >>> 2;
        r4 = CPU.lr().value;
        r2 = CPU.r10().value;
        r2 = r2 << r3;
        r3 = MEMORY.ref(1, r4).getUnsigned();
        r2 = r2 | r3;
        MEMORY.ref(1, r4).setu(r2);
        r0 = r0 - 0x1;
        r6 = r6 + 0x40;
        r1 = r1 + 0x1;
      } while(r0 != 0);
    }

    //LAB_8022802
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
  }

  @Method(0x802281c)
  public static void FUN_802281c(final int r0) {
    final BattleStruct82c r7 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    final int charCount = getUnitIds_(0x1, null);
    FUN_8022768(29 - charCount * 6, 0, 25, 5, 15);

    //LAB_8022856
    for(int r6 = 0; r6 < 4 && MEMORY.ref(2, r0 + r6 * 0x2).getUnsigned() != 0xff; r6++) {
      //LAB_802286e
      int r1;
      for(r1 = 0; r1 < 4; r1++) {
        final int charId;
        if((charId = r7.charIds_58.get(r1).get()) == MEMORY.ref(2, r0 + r6 * 0x2).getUnsigned()) {
          break;
        }

        if(charId == 0xff) {
          r1 = 0x4;
          break;
        }

        //LAB_8022860
      }

      //LAB_8022878
      if(r1 != 0x4) {
        FUN_8022768(29 - (charCount - r1) * 6, 0, 7, 5, 14);
      }

      //LAB_8022898
    }

    //LAB_80228a8
  }

  @Method(0x8023178)
  public static int FUN_8023178(final int[] charIds, final int charCount, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8023e70)
  public static int FUN_8023e70(final int r0) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8024934)
  public static int FUN_8024934(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8025180)
  public static int FUN_8025180(final int charId, final int itemId) {
    if(itemId == 0) {
      return 1;
    }

    final Item2c r5 = getItem_(itemId);

    if(r5.useType_0c.get() == 3 || r5.useAbility_28.get() == 0 || r5.type_02.get() != 0 && isEquipped_(charId, itemId) == 0) {
      return 1;
    }

    //LAB_80251b8
    if((MEMORY.ref(1, getAbility_(r5.useAbility_28.get()) + 0x1).getUnsigned() & 0x80) == 0) {
      return 2;
    }

    //LAB_80251cc
    return 0;
  }

  @Method(0x8025200)
  public static int FUN_8025200(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x802592c)
  public static int FUN_802592c(final int r0, final int r1, final int r2) {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x8026080)
  public static int FUN_8026080(int r0, int r1, int r2, int r3) {
    int r4;
    int r5;
    int r6;
    int r7;
    int r8;
    Panel24 r9;
    int r10;

    CPU.sp().value -= 0x144;
    int sp54 = r2;
    final int sp50 = r3;
    r10 = r0;
    final BattleStruct82c sp4c = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    r8 = r1;
    int sp40 = 0;
    int sp38 = 0xffff;
    final int sp34 = allocateFirstFreeSpriteSlot(0x100);
    r9 = null;
    if(sp54 == 0) {
      sp54 = 1;
    }

    //LAB_80260be
    if(r8 == 0x2 || r8 == 0x4) {
      //LAB_80260c8
      r3 = -2;
    } else {
      //LAB_80260d4
      r3 = 16;
    }

    //LAB_80260dc
    r2 = boardWramMallocHead_3001e50.offset(57 * 0x4).get();
    MEMORY.ref(4, r2 + 0x28).setu(r3);
    final int sp24 = CPU.sp().value + 0xd4;
    r7 = 0x5;
    r3 = CPU.sp().value + 0xea;

    //LAB_80260ec
    do {
      r7 = r7 - 0x1;
      MEMORY.ref(1, r3).setu(0);
      r3 = r3 - 0x4;
    } while(r7 >= 0);

    int sp44 = -1;
    final int sp1c = CPU.sp().value + 0x134;

    if(r8 == 0x2) {
      //LAB_8026194
      //LAB_8026120
      for(r7 = 0; r7 < 6 && (r3 = sp4c.charIds_58.get(r7).get()) != 0xff; r7++) {
        MEMORY.ref(2, sp1c + sp40 * 0x2).setu(r3);
        sp40++;
      }
      //LAB_802613e
    } else if(r8 == 0x4) {
      MEMORY.ref(2, sp1c).setu(r10);
      sp40 = 1;
    } else {
      //LAB_8026158
      //LAB_8026178
      for(r7 = 0; r7 < 6 && (r3 = sp4c.monsterIds_66.get(r7).get()) != 0xff; r7++) {
        MEMORY.ref(2, sp1c + sp40 * 0x2).setu(r3);
        sp40++;
      }
    }

    //LAB_80261b8
    MEMORY.ref(2, sp1c + sp40 * 0x2).setu(0xff);
    final int sp3c = sp40;
    if(r8 == 0x2) {
      //LAB_80261cc
      if(sp54 != 0xff && sp50 != 0) {
        r5 = 0x0;
        r7 = 0x0;
        if(r5 < sp40) {
          r6 = 0x0;

          //LAB_80261f0
          do {
            r3 = MEMORY.ref(2, sp1c + r6).getUnsigned();
            if(r3 != 0xfe) {
              final Unit14c unit = getCharOrMonsterData_(r3);
              if(sp50 != 0x4) {
                if((sp50 & 0xffff_ffffL) <= (0x4 & 0xffff_ffffL)) {
                  if(sp50 == 0x3) {
                    //LAB_8026234
                    if(unit.affliction_131.get() != 0) {
                      //LAB_80262a4
                      r7 = 0x1;
                    }
                  }
                } else {
                  //LAB_8026216
                  if(sp50 == 0x5) {
                    //LAB_8026222
                    if(unit.hp_38.get() == 0) {
                      r10 = MEMORY.ref(2, sp1c + r6).getUnsigned();
                      r7 = 0x1;
                    }
                    //LAB_8026264
                  } else if(sp50 == 0x6 && (unit._138.get() != 0 && unit._13b.get() != 0 || unit._13c.get() != 0 && unit._13d.get() != 0 || unit._141.get() != 0 || unit.affliction_131.get() != 0 || unit.haunt_140.get() != 0)) {
                    r7 = 0x1;
                  }
                }
                //LAB_8026240
              } else if(unit._138.get() != 0 && unit._13b.get() != 0 || unit._13c.get() != 0 && unit._13d.get() != 0 || unit._141.get() != 0) {
                r7 = 0x1;
              }

              //LAB_80262a6
              if(r7 != 0) {
                //LAB_802619e
                r10 = MEMORY.ref(2, sp1c + r6).getUnsigned();
                break;
              }
            }

            //LAB_80262ac
            r5 = r5 + 0x1;
            r6 = r6 + 0x2;
          } while(r5 < sp40);
        }
      }

      //LAB_80262b6
      //LAB_80262c8
      for(r5 = 0; r5 < sp40 && MEMORY.ref(2, sp1c + r5 * 0x2).getUnsigned() != r10; r5++) {
        //
      }

      //LAB_80262d8
      if(r5 != sp40) {
        sp44 = r5;
      }
    }

    //LAB_80262e0
    if(sp44 < 0) {
      sp44 = (sp40 - 1) / 2;
    }

    //LAB_8026308
    while(MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned() == 0xfe || (readFlag_(0x16c) != 0 && r8 == 0x1 && getCharOrMonsterData_(MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned()).hp_38.get() == 0)) {
      //LAB_80262f4
      sp44 = modS(sp44 + sp40 - 1, sp40);
    }

    //LAB_8026336
    if(r8 != 0x2) {
      final Vec3 vec = new Vec3();
      FUN_80b50b8(r10, vec);
      MEMORY.ref(1, sp24).setu(vec.getX());
      MEMORY.ref(1, sp24 + 0x1).setu(0x80);
      MEMORY.ref(1, sp24 + 0x2).setu(0x8);
    }

    //LAB_8026354
    final Panel24 sp48 = addPanel(0, 12, 30, 4, 74);
    final int sp20 = CPU.sp().value + 0xec;
    final int sp14 = CPU.sp().value + 0x58;
    final Vec3 r11 = new Vec3();

    //LAB_802638e
    do {
      int sp30 = 0;
      FUN_80b50b8(MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned(), r11);
      MEMORY.ref(4, sp20 + 0x4).setu(0x40002000);
      MEMORY.ref(4, sp20 + 0x8).setu(0);
      r1 = _3001e40.get();
      r1 = r1 >>> 2;
      r1 = r1 & 0x1f;
      r3 = 0x80346f8;
      r1 = r1 << 8;
      r1 = r1 + r3;
      r0 = FUN_80040d0(sp34, r1);
      r0 = r0 & 0x3ff;
      r2 = MEMORY.ref(2, sp20 + 0x8).getUnsigned();
      r3 = 0xfffffc00;
      r3 = r3 & r2;
      r3 = r3 | r0;
      MEMORY.ref(2, sp20 + 0x8).setu(r3);
      r0 = r11.getY() + sin(_3001e40.get() << 12) / 0x8000;
      r11.setY(r0);
      r2 = MEMORY.ref(1, sp24 + 0x2).getUnsigned();
      if((r2 & 0x1) != 0) {
        r4 = r11.getX();
        r3 = r4 + MEMORY.ref(1, sp24).getUnsigned();
        r1 = r3 / 2;
        r3 = r11.getY() + MEMORY.ref(1, sp24 + 0x1).getUnsigned();
        r0 = r3 / 2;
        r3 = r4 - r1;
        //LAB_802643c
        if(r3 < 0) {
          //LAB_8026436
          r3 = r1 - r4;
        }

        if(r3 <= 0x7) {
          sp30 = 1;
        }

        //LAB_8026440
        r11.setX(r1);
        r11.setY(r0);
        MEMORY.ref(1, sp24).setu(r1);
        MEMORY.ref(1, sp24 + 0x1).setu(r0);
      } else {
        //LAB_802644e
        r3 = r2 << 24;
        if((r3 & 0xffff_ffffL) <= 0x3000000) {
          r3 = r11.getX();
          r11.setY(r0);
          MEMORY.ref(1, sp24).setu(r3);
          MEMORY.ref(1, sp24 + 0x1).setu(r0);
          MEMORY.ref(1, sp24 + 0x2).setu(1);
        } else {
          //LAB_8026468
          r11.setX(MEMORY.ref(1, sp24).getUnsigned());
          r11.setY(MEMORY.ref(1, sp24 + 0x1).getUnsigned());
          r3 = r2 + 0xfc;
          MEMORY.ref(1, sp24 + 0x2).setu(r3);
          r3 = r3 << 24;
          if((r3 & 0xffff_ffffL) <= 0x3000000) {
            MEMORY.ref(1, sp24 + 0x2).setu(1);
          }
        }
      }

      //LAB_8026486
      MEMORY.ref(2, sp20 + 0x6).and(~0x1ff).or(r11.getX() - 8 & 0x1ff);
      MEMORY.ref(1, sp20 + 0x4).setu(r11.getY() - 0x10);
      insertIntoRenderQueue(MEMORY.ref(4, sp20, RenderPacket0c::new), 240);
      if(sp54 == 0xff) {
        r2 = 0xffff0000;
        r3 = MEMORY.ref(4, sp14).get();
        r3 = r3 & r2;
        r3 = r3 | 0x100;
        r3 = r3 & 0xffff;
        r2 = 0x1000000;
      } else {
        //LAB_80264d8
        r2 = 0xffff0000;
        r3 = MEMORY.ref(4, sp14).get();
        r3 = r3 & r2;
        r3 = r3 | 0xb0;
        r3 = r3 & 0xffff;
        r2 = 0xb00000;
      }

      //LAB_80264ea
      r3 = r3 | r2;
      MEMORY.ref(4, sp14).setu(r3);
      r3 = 0xffff0000;
      r2 = MEMORY.ref(4, sp14 + 0x4).get();
      r2 = r2 & r3;
      MEMORY.ref(4, sp14 + 0x4).setu(r2);
      final int sp2c = addRotScaleParams(sp14);

      if((sp38 & 0x1) != 0) {
        //LAB_802650c
        sp40 = 0;
        r1 = sp24;
        r7 = 0x5;

        //LAB_8026516
        do {
          MEMORY.ref(1, r1 + 0x2).and(~0x2);
          r1 = r1 + 0x4;
          r7 = r7 - 0x1;
        } while(r7 >= 0);

        r10 = CPU.sp().value + 0xac;
        r4 = sp24;
        r6 = sp40 + CPU.sp().value + 0xa4;
        r0 = r4 + 0x18;

        //LAB_8026552
        for(r7 = 0; r7 < (sp54 & 0xffff_ffffL); r7++) {
          r3 = sp44 + r7;
          if(r3 < sp3c) {
            r2 = MEMORY.ref(2, sp1c + r3 * 0x2).getUnsigned();
            if(r2 != 0xfe) {
              MEMORY.ref(2, r10 + sp40 * 0x2).setu(r2);
              MEMORY.ref(1, r4 + 0x2).or(0x2);

              if(MEMORY.ref(1, r4 + 0x3).get() != r7) {
                MEMORY.ref(1, r4 + 0x2).and(~0x1);
                MEMORY.ref(1, r4 + 0x3).setu(r7);
              }

              //LAB_8026586
              MEMORY.ref(1, r6).setu(r7);
              sp40++;
              r6++;
            }
          }

          //LAB_8026592
          if(r7 != 0) {
            r3 = sp44 - r7;
            if(r3 >= 0) {
              r2 = MEMORY.ref(2, sp1c + r3 * 0x2).getUnsigned();
              if(r2 != 0xfe) {
                MEMORY.ref(2, r10 + sp40 * 0x2).setu(r2);
                MEMORY.ref(1, r0 + 0x2).or(0x2);

                if(MEMORY.ref(1, r0 + 0x3).get() != -r7) {
                  MEMORY.ref(1, r0 + 0x2).and(~0x1);
                  MEMORY.ref(1, r0 + 0x3).setu(-r7);
                }

                //LAB_80265d0
                MEMORY.ref(1, r6).setu(6 - r7);
                sp40++;
                r6++;
              }
            }
          }

          //LAB_80265de
          r4 = r4 + 0x4;
          r0 = r0 - 0x4;
        }

        //LAB_80265f8
        r1 = sp24;
        r7 = 0x5;

        //LAB_8026600
        do {
          if((MEMORY.ref(1, r1 + 0x2).getUnsigned() & 0x2) == 0) {
            MEMORY.ref(1, r1 + 0x3).setu(6);
          }

          //LAB_802660c
          r7 = r7 - 0x1;
          r1 = r1 + 0x4;
        } while(r7 >= 0);

        MEMORY.ref(2, r10 + sp40 * 0x2).setu(0xff);
        FUN_80b50e0(r10, 1);
        r3 = MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned();
        if((r3 & 0xffff_ffffL) > 7) {
          //LAB_8026a84
          if(sp54 != 0xff) {
            //LAB_8026a8c
            final Unit14c unit = getCharOrMonsterData_(MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned());
            final Vec3 sp0x6c = new Vec3();
            FUN_80b50b8(MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned(), sp0x6c);
            sp0x6c.y_04.add(sin(_3001e40.get() << 12) / 0x8000);
            final ArrayRef<UnsignedShortRef> str = MEMORY.ref(2, CPU.sp().value + 0x78, ArrayRef.of(UnsignedShortRef.class, 15, 0x2, UnsignedShortRef::new));
            if(unit.id_128.get() == 0x7d || unit.id_128.get() == 0x7a) {
              //LAB_8026ad6
              //LAB_8026ae6
              FUN_801965c(unit.id_128.get() == 0x7d ? 0x80f : 0x80e, str, 14);
            } else {
              r7 = 0;

              //LAB_8026af2
              do {
                if(r7 > 13) {
                  //LAB_8026b44
                  break;
                }
                r3 = unit.name_00.get(r7).get();
                str.get(r7).set(r3);
                r7 = r7 + 0x1;
              } while(r3 != 0);

              //LAB_8026b46
              str.get(r7).set(0);
            }

            //LAB_8026b4a
            r0 = FUN_8017a64(str);
            r2 = r0 / 2;
            r3 = sp0x6c.getX() - r2 - 0x8;
            sp0x6c.setX(r3);
            r3 = r3 + r0;
            if(r3 > 0xe0) {
              sp0x6c.setX(0xe0 - r0);
            }

            //LAB_8026b6a
            if(sp0x6c.getX() < 0) {
              sp0x6c.setX(0);
            }

            //LAB_8026b7c
            FUN_801671c();
            FUN_8017aa4(str, sp48, sp0x6c.getX(), 4);
          }
        } else {
          //LAB_8026632
          if(sp54 != 0xff) {
            //LAB_802663a
            if(sp50 != 0) {
              //LAB_8026642
              final Unit14c unit = getCharOrMonsterData_(r3);
              FUN_80b50b8(MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned(), r11);

              if(r9 != null) {
                FUN_8016418(r9, 1);
              }

              //LAB_8026668
              r3 = sp50 - 0x1;
              if((r3 & 0xffff_ffffL) < 7) {
                //LAB_8026672
                switch(r3) {
                  case 6 -> {
                    //LAB_8026698
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 25 ? 22 : r3 - 4, 8, 9, 3, 0x6);
                    FUN_801e71c(2);
                    FUN_801e7c0(0x8ac, r9, 0, 0);
                    FUN_801e71c(15);
                  }

                  case 0 -> {
                    //LAB_80266c8
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 23 ? 17 : r3 - 7, 8, 13, 3, 0x6);
                    FUN_801e8b0(0x80373dc, r9, 0, 0);
                    FUN_801ea08(unit.hp_38.get(), 4, r9, 16, 0);
                    FUN_801e8b0(0x80373e0, r9, 48, 0);
                    FUN_801ea08(unit.maxHp_34.get(), 4, r9, 56, 0);
                  }

                  case 1 -> {
                    //LAB_802671e
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 23 ? 17 : r3 - 7, 8, 13, 3, 0x6);
                    FUN_801e8b0(0x80373e4, r9, 0, 0);
                    FUN_801ea08(unit.pp_3a.get(), 4, r9, 16, 0);
                    FUN_801e8b0(0x80373e0, r9, 48, 0);
                    FUN_801ea08(unit.maxPp_36.get(), 4, r9, 56, 0);
                  }

                  case 4 -> {
                    //LAB_8026780
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 24 ? 18 : r3 - 7, 8, 12, 3, 0x6);
                    if(unit.hp_38.get() != 0) {
                      FUN_801e71c(2);
                      FUN_801e7c0(0x8a3, r9, 0, 0);
                      FUN_801e71c(15);
                    } else {
                      //LAB_80267b0
                      FUN_801e7c0(0x8ab, r9, 0, 0);
                    }
                  }

                  case 2 -> {
                    //LAB_80267b4
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 24 ? 18 : r3 - 7, 8, 12, 3, 0x6);
                    if(unit.affliction_131.get() == 0) {
                      FUN_801e71c(2);
                      FUN_801e7c0(0x8a3, r9, 0, 0);
                      FUN_801e71c(15);
                    } else {
                      //LAB_80267ea
                      FUN_801e7c0(0x8a4, r9, 0, 0);
                    }
                  }

                  case 3 -> {
                    r5 = 0;

                    //LAB_80267f8
                    if(unit._138.get() != 0) {
                      r5++;
                    }

                    //LAB_8026808
                    if(unit._13b.get() != 0) {
                      r5++;
                    }

                    //LAB_8026816
                    if(unit._13c.get() != 0) {
                      r5++;
                    }

                    //LAB_8026826
                    if(unit._13d.get() != 0) {
                      r5++;
                    }

                    //LAB_8026834
                    if(unit._141.get() != 0) {
                      r5++;
                    }

                    //LAB_8026840
                    if(r5 == 0) {
                      r5 = 1;
                    }

                    //LAB_8026846
                    r1 = 9 - r5;
                    if(r1 < 4) {
                      r1 = 4;
                    }

                    //LAB_8026850
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 20 ? 14 : r3 - 7, r1, 16, r5 + 2, 0x6);
                    r5 = 0;
                    if(unit._138.get() != 0) {
                      FUN_801e7c0(0x8a5, r9, 0, 0);
                      r5++;
                    }

                    //LAB_802688a
                    if(unit._13b.get() != 0) {
                      FUN_801e7c0(0x8a6, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_80268a0
                    if(unit._13c.get() != 0) {
                      FUN_801e7c0(0x8a7, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_80268b6
                    if(unit._13d.get() != 0) {
                      FUN_801e7c0(0x8a8, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_80268cc
                    if(unit._141.get() != 0) {
                      //LAB_80268d4
                      FUN_801e7c0(0x8a9, r9, 0, r5 * 8);
                      r5++;
                    }

                    if(r5 == 0) {
                      //LAB_8026a6a
                      FUN_801e71c(2);
                      FUN_801e7c0(0x8a3, r9, 0, 0);
                      FUN_801e71c(15);
                    }
                  }

                  case 5 -> {
                    r5 = 0;

                    //LAB_802691c
                    if(unit.affliction_131.get() != 0) {
                      r5++;
                    }

                    //LAB_802692e
                    if(unit._138.get() != 0) {
                      r5++;
                    }

                    //LAB_802693c
                    if(unit._13b.get() != 0) {
                      r5++;
                    }

                    //LAB_8026948
                    if(unit._13c.get() != 0) {
                      r5++;
                    }

                    //LAB_8026956
                    if(unit._13d.get() != 0) {
                      r5++;
                    }

                    //LAB_8026962
                    if(unit._141.get() != 0) {
                      r5++;
                    }

                    //LAB_802696e
                    if(unit.haunt_140.get() != 0) {
                      r5++;
                    }

                    //LAB_802697c
                    if(r5 == 0) {
                      r5 = 1;
                    }

                    //LAB_8026982
                    r1 = 9 - r5;
                    if(r1 < 4) {
                      r1 = 4;
                    }

                    //LAB_802698c
                    r3 = r11.getX() / 8;
                    r9 = addPanel(r3 > 20 ? 14 : r3 - 7, r1, 16, r5 + 2, 0x6);
                    r5 = 0;
                    if(unit.affliction_131.get() != 0) {
                      FUN_801e7c0(0x8a4, r9, 0, 0);
                      r5++;
                    }

                    //LAB_80269ce
                    if(unit._138.get() != 0) {
                      FUN_801e7c0(0x8a5, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_80269e8
                    if(unit._13b.get() != 0) {
                      FUN_801e7c0(0x8a6, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_8026a00
                    if(unit._13c.get() != 0) {
                      FUN_801e7c0(0x8a7, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_8026a1a
                    if(unit._13d.get() != 0) {
                      FUN_801e7c0(0x8a8, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_8026a32
                    if(unit._141.get() != 0) {
                      FUN_801e7c0(0x8a9, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_8026a4a
                    if(unit.haunt_140.get() != 0) {
                      FUN_801e7c0(0x8aa, r9, 0, r5 * 8);
                      r5++;
                    }

                    //LAB_8026a64
                    if(r5 == 0) {
                      //LAB_8026a6a
                      FUN_801e71c(2);
                      FUN_801e7c0(0x8a3, r9, 0, 0);
                      FUN_801e71c(15);
                    }
                  }
                }
              }
            }
          }
        }

        //LAB_8026b8c
        sp38 &= ~0x1;
      }

      //LAB_8026b96
      if(sp30 != 0) {
        //LAB_8026b9e
        r7 = 0x1;
        if(r7 < sp40) {
          //LAB_8026ba8
          MEMORY.ref(4, CPU.sp().value + 0x10).setu(CPU.sp().value + 0xa4);
          final Vec3 sp0x60 = new Vec3();
          r5 = sp20 + 0xc;
          r10 = CPU.sp().value + 0xac;
          MEMORY.ref(4, CPU.sp().value + 0xc).setu(2);

          //LAB_8026bc4
          do {
            r1 = MEMORY.ref(4, CPU.sp().value + 0x10).get();
            r3 = MEMORY.ref(1, r1 + r7).getUnsigned();
            MEMORY.ref(4, CPU.sp().value + 0x4).setu(sp24 + r3 * 0x4);
            r3 = MEMORY.ref(4, CPU.sp().value + 0xc).get();
            r0 = MEMORY.ref(2, r3 + r10).getUnsigned();
            FUN_80b50b8(r0, sp0x60);
            sp0x60.y_04.add(sin(_3001e40.get() << 12) / 0x8000);
            MEMORY.ref(4, r5).setu(MEMORY.ref(4, sp20).get());
            MEMORY.ref(4, r5 + 0x4).setu(MEMORY.ref(4, sp20 + 0x4).get());
            MEMORY.ref(4, r5 + 0x8).setu(MEMORY.ref(4, sp20 + 0x8).get());

            r3 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
            if((MEMORY.ref(1, r3 + 0x2).getUnsigned() & 0x1) != 0) {
              r6 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              r1 = (sp0x60.getX() + MEMORY.ref(1, r6).getUnsigned()) / 2;
              r3 = (sp0x60.getY() + MEMORY.ref(1, r6 + 0x1).getUnsigned()) / 2;
              sp0x60.setX(r1);
              MEMORY.ref(1, r6).setu(r1);
              sp0x60.setY(r3);
              MEMORY.ref(1, r6 + 0x1).setu(r3);
            } else {
              //LAB_8026c3a
              r3 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
              r2 = MEMORY.ref(1, r5 + 0x4).getUnsigned();
              r0 = MEMORY.ref(4, CPU.sp().value + 0x4).get();
              r3 = r3 << 23;
              r3 = r3 >>> 23;
              r2 = r2 + 0x8;
              MEMORY.ref(1, r0 + 0x2).setu(1);
              sp0x60.setX(r3);
              MEMORY.ref(1, r0).setu(r3);
              sp0x60.setY(r2);
              MEMORY.ref(1, r0 + 0x1).setu(r2);
            }

            //LAB_8026c50
            r2 = MEMORY.ref(1, r5 + 0x5).getUnsigned();
            r0 = r2 & ~0xc | 0x4;
            MEMORY.ref(1, r5 + 0x4).setu(sp0x60.getY() - 12);
            MEMORY.ref(1, r5 + 0x5).setu(r0);
            MEMORY.ref(2, r5 + 0x6).and(~0x1ff).or(sp0x60.getX() - 8 & 0x1ff);

            if(sp54 == 0xff) {
              r0 = r0 & ~0x3;
            } else {
              //LAB_8026c9c
              r0 = r0 & ~0x3 | 0x1;
            }

            //LAB_8026ca6
            MEMORY.ref(1, r5 + 0x5).setu(r0);
            MEMORY.ref(1, r5 + 0x7).and(~0x3e).or((sp2c & 0x1f) << 1);
            insertIntoRenderQueue(MEMORY.ref(4, r5, RenderPacket0c::new), 240);

            MEMORY.ref(4, CPU.sp().value + 0xc).addu(0x2);
            r5 += 0xc;
            r7++;
          } while(r7 < sp40);
        }
      }

      //LAB_8026cdc
      r3 = 0x3001c94;
      r6 = MEMORY.ref(4, r3).get();
      r3 = 0x3001b04;
      r5 = MEMORY.ref(4, r3).get();
      r3 = 0x3001f34;
      r2 = MEMORY.ref(4, r3).get();
      if(MEMORY.ref(4, r2 + 0xd8).get() != 0) {
        if(MEMORY.ref(4, r2 + 0xdc).get() == 0) {
          MEMORY.ref(4, r2 + 0xdc).setu(60);
          r5 = 0x1;
          r6 = 0x1;
        } else {
          //LAB_8026d08
          MEMORY.ref(4, r2 + 0xdc).decr();
          r5 = 0x0;
          r6 = 0x0;
        }
      }

      //LAB_8026d0c
      if((r6 & 0x1) != 0) {
        r4 = MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned();
        sp38 = 0;
        r3 = sp4c.charIds_58.get(0).get();
        r0 = -1;
        r1 = 0x0;
        if(r3 != 0xff) {
          if(r3 == r4) {
            r0 = 0x100;
          } else {
            //LAB_8026d38
            do {
              r1 = r1 + 0x1;
              if(r1 > 0x5) {
                break;
              }
              r3 = sp4c.charIds_58.get(r1).get();
              if(r3 == 0xff) {
                break;
              }
              if(r3 == r4) {
                r0 = 0x100 | r1;
                break;
              }
            } while(true);
          }
        }

        //LAB_8026d54
        if(r0 < 0) {
          r3 = sp4c.monsterIds_66.get(0).get();
          r1 = 0x0;
          if(r3 != 0xff) {
            if(r3 == r4) {
              r0 = 0x180;
            } else {
              //LAB_8026d72
              do {
                r1 = r1 + 0x1;
                if(r1 > 0x5) {
                  break;
                }
                r3 = sp4c.monsterIds_66.get(r1).get();
                if(r3 == 0xff) {
                  break;
                }
                if(r3 == r4) {
                  r0 = 0x180 | r1;
                  break;
                }
              } while(true);
            }
          }
        }

        //LAB_8026d8a
        sp44 = r0;
      } else {
        //LAB_8026d8e
        if(sp54 != 0xff) {
          if((r5 & 0x90) != 0) {
            playSound_(0x6f);

            //LAB_8026da2
            do {
              sp44 = modS(sp44 + 1, sp3c);
              r3 = MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned();
            } while(r3 == 0xfe);

            sp38 |= 0x1;
          }

          //LAB_8026dc4
          if((r5 & 0x60) != 0) {
            playSound_(0x6f);

            //LAB_8026dd2
            do {
              sp44 = modS(sp44 + sp3c - 1, sp3c);
              r3 = MEMORY.ref(2, sp1c + sp44 * 0x2).getUnsigned();
            } while(r3 == 0xfe);

            sp38 |= 0x1;
          }
        }
      }

      //LAB_8026df6
      r3 = 0x3001f34;
      r3 = MEMORY.ref(4, r3).get();
      r3 = MEMORY.ref(4, r3 + 0x4c).get();
      if(r3 == 0 || (r6 & 0x2) != 0) {
        //LAB_8026e08
        playSound_(0x71);
        sp44 = -1;
        break;
      }

      //LAB_8026e16
      sleep(1);
      if(sp38 == 0) {
        break;
      }
    } while(true);

    //LAB_8026e26
    sleep(1);
    clearVramSlot(sp34);

    if(r9 != null) {
      FUN_8016418(r9, 1);
    }

    //LAB_8026e40
    FUN_8016418(sp48, 1);
    FUN_80b50e0(sp1c, 0);
    r3 = 0x3001f34;
    r2 = MEMORY.ref(4, r3).get();
    MEMORY.ref(4, r2 + 0x28).setu(0);
    sleep(1);
    CPU.sp().value += 0x144;
    return sp44;
  }

  @Method(0x8026e80)
  public static void FUN_8026e80() {
    int r0;
    final int r3;
    int r5;
    int r6;
    final int r7;

    r3 = 0x3001f34;
    r7 = MEMORY.ref(4, r3).get();
    if(r7 == 0) {
      return;
    }

    //LAB_8026e8e
    r0 = MEMORY.ref(4, r7 + 0x28).get();
    r5 = MEMORY.ref(4, r7 + 0x2c).get();
    if(r0 != r5) {
      r6 = r0 - r5;
      r0 = divideS(r6, 3);
      if(r0 == 0) {
        if(r6 >= 0) {
          r0 = 1;
        } else {
          r0 = -1;
        }
      }

      //LAB_8026eac
      r0 = r5 + r0;
      MEMORY.ref(4, r7 + 0x2c).setu(r0);
      FUN_80b50d0(r0);
    }

    //LAB_8026eb4
    //LAB_8026ebc
    for(int i = 0; i < 2; i++) {
      if(MEMORY.ref(1, r7 + 0x24 + i).getUnsigned() != 0) {
        insertIntoRenderQueue(MEMORY.ref(4, r7 + i * 0xc, RenderPacket0c::new), 240);
      }

      //LAB_8026ed0
    }

    FUN_80219c8(0x6006680);

    if(MEMORY.ref(4, r7 + 0x50).get() == 0) {
      return;
    }

    final BattleStruct82c r2 = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    if(r2._52.get() != 0) {
      MEMORY.ref(4, r7 + 0x4c).setu(0);
      return;
    }

    //LAB_8026f0e
    r6 = MEMORY.ref(4, r7 + 0x4c).get();
    if(r6 < 0) {
      final int r2_0 = 0x2002024 + (r2._50.get() ^ 0x1) * 0x18;
      if(MEMORY.ref(2, r2_0 + 0x8).getUnsigned() == 0x45) {
        if(MEMORY.ref(2, r2_0 + 0xa).getUnsigned() == 0x44) {
          //LAB_8026ef8
          if(MEMORY.ref(2, r2_0 + 0xc).getUnsigned() == 0x56) {
            if(MEMORY.ref(2, r2_0 + 0xe).getUnsigned() == 0x53) {
              MEMORY.ref(4, r7 + 0x4c).setu(900);
              r6 = 900;
            }
          }
        }
      }

      //LAB_8026f34
      if(r6 < 0) {
        return;
      }
    }

    //LAB_8026f38
    if(MEMORY.ref(4, r7 + 0x44).get() == 0 && MEMORY.ref(4, r7 + 0x48).get() == 0) {
      MEMORY.ref(4, r7 + 0x44).setu(FUN_8021c34().getAddress());
      r6 = MEMORY.ref(4, r7 + 0x4c).get();
    }

    //LAB_8026f4c
    if(r6 > 0) {
      r6--;
      MEMORY.ref(4, r7 + 0x4c).setu(r6);
    }

    //LAB_8026f56
    if(r6 >= 0) {
      r5 = divideS(r6 + 59, 60);
      if(r5 != 0 && r5 * 60 == r6) {
        playSound_(0x6c);
      }

      //LAB_8026f7a
      final int panel = MEMORY.ref(4, r7 + 0x44).get();
      if(panel != 0) {
        FUN_801ea08(r5, 2, MEMORY.ref(4, panel, Panel24::new), 16, 8);
      }
    }

    //LAB_8026f8e
  }

  @Method(0x8026fa8)
  public static int FUN_8026fa8() {
    throw new RuntimeException("Not implemented");
  }

  @Method(0x802706c)
  public static int FUN_802706c(int r0) {
    final int r2 = MEMORY.ref(1, r0 + 0x1).getUnsigned() & 0xf;
    int r5 = 0;
    if(r2 == 0x1) {
      r5 = 0x1;
    }

    //LAB_802707c
    if(r2 == 0xb) {
      r5 = 0x2;
    }

    //LAB_8027082
    final int r3 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
    if(r3 == 0x3) {
      r5 = 0x3;
    }

    //LAB_802708a
    if(r3 == 0x4) {
      r5 = 0x4;
    }

    //LAB_8027090
    if(r3 == 0x40) {
      r5 = 0x6;
    }

    //LAB_8027096
    r0 = MEMORY.ref(1, r0 + 0x3).getUnsigned();
    r0 = FUN_80772b8(r0);
    if(r0 != 0) {
      r5 = 0x5;
    }

    //LAB_80270a2
    return r5;
  }

  @Method(0x80270ac)
  public static void FUN_80270ac() {
    CPU.sp().value -= 0x4;
    final int r5 = CPU.sp().value;
    MEMORY.ref(2, r5).setu(0xff);
    FUN_802281c(r5);
    FUN_80b50e0(r5, 1);
    CPU.sp().value += 0x4;
  }

  /** NOTE: takes r9 as param */
  @Deprecated
  @Method(0x80270d8)
  public static void FUN_80270d8() {
    CPU.push(CPU.r9().value);
    CPU.sp().value -= 0x84;
    final int r2 = CPU.r9().value;
    final ArrayRef<UnsignedShortRef> r6 = MEMORY.ref(2, CPU.sp().value, ArrayRef.of(UnsignedShortRef.class, 64, 0x2, UnsignedShortRef::new));
    MEMORY.ref(4, CPU.sp().value + 0x80).setu(r2);
    FUN_801965c(0x80d, r6, 52);
    final int r3 = MEMORY.ref(4, r2 - 0x8).get();
    FUN_8017aa4(r6, MEMORY.ref(4, r3 + 0x44).deref(4).cast(Panel24::new), 0, 4);
    CPU.sp().value += 0x84;
    CPU.r9().value = CPU.pop();
  }

  @Method(0x8027114)
  public static int FUN_8027114(final BattleStruct82c.Turn10 r0, int r1, int r2) {
    int r3;
    int r4;
    int r5;
    int r6;
    int r7;
    Panel24 r11;

    CPU.push(CPU.r10().value);
    CPU.push(CPU.r9().value);
    CPU.push(CPU.r8().value);
    CPU.sp().value -= 0x64;
    MEMORY.ref(4, CPU.sp().value + 0x44).setu(0x100);
    MEMORY.ref(4, CPU.sp().value + 0x54).setu(r1);
    MEMORY.ref(4, CPU.sp().value + 0x50).setu(r2);
    MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x38).setu(0);
    MEMORY.ref(4, CPU.sp().value + 0x34).setu(allocateFirstFreeSpriteSlot(0x400));
    MEMORY.ref(4, CPU.sp().value + 0x30).setu(allocateFirstFreeSpriteSlot(0x200));
    MEMORY.ref(4, CPU.sp().value + 0x5c).setu(mallocSlotBoard(57, 0x104));
    final int sp24 = CPU.sp().value + 0x5c;
    FUN_8021c64(MEMORY.ref(4, CPU.sp().value + 0x34).get(), 0);
    FUN_8021a18(0x6006000);
    FUN_80219c8(0x6006680);
    FUN_8021848();
    final BattleStruct82c struct = boardWramMallocHead_3001e50.offset(9 * 0x4).deref(4).cast(BattleStruct82c::new);
    int r0_0;
    r3 = MEMORY.ref(4, sp24).get();
    r3 = r3 + 0xe4;
    r2 = 0x7;

    //LAB_8027184
    do {
      r2 = r2 - 0x1;
      MEMORY.ref(4, r3).setu(0x80000000);
      r3 += 0x4;
    } while(r2 >= 0);

    r3 = MEMORY.ref(4, sp24).get();
    r3 = r3 + 0x24;
    r2 = 0x2;

    //LAB_8027196
    do {
      r2 = r2 - 0x1;
      MEMORY.ref(1, r3).setu(0);
      r3 = r3 + 0x1;
    } while(r2 >= 0);

    r1 = MEMORY.ref(4, sp24).get();
    MEMORY.ref(4, r1 + 0x28).setu(0);
    MEMORY.ref(4, r1 + 0x2c).setu(0);
    MEMORY.ref(4, r1 + 0x3c).setu(0);
    MEMORY.ref(4, r1 + 0x40).setu(0);
    MEMORY.ref(4, r1 + 0x50).setu(0);
    MEMORY.ref(4, r1 + 0x48).setu(0);
    MEMORY.ref(4, r1 + 0x44).setu(0);
    MEMORY.ref(4, r1 + 0x4c).setu(-1);

    if(struct._44.get() != 0) {
      r2 = 0x2002224;
      MEMORY.ref(4, r1 + 0x50).setu(1);
      MEMORY.ref(2, r2 + 0x8).setu(0x56);
      MEMORY.ref(2, r2 + 0xa).setu(0x53);
      MEMORY.ref(2, r2 + 0xc).setu(0x53);
      r5 = 0x0;
      MEMORY.ref(2, r2 + 0xe).setu(0x54);

      //LAB_802727a
      do {
        r1 = 0x2002024 + (struct._50.get() ^ 0x1) * 0x18;
        if(struct._52.get() != 0) {
          MEMORY.ref(4, CPU.sp().value + 0x50).setu(-1);
          r3 = MEMORY.ref(4, sp24).get();
          MEMORY.ref(4, r3 + 0x50).setu(0);
          break;
        }

        //LAB_8027200
        if((_3001f64.get() & 0x3) == 0x3) {
          //LAB_8027220
          r5 = 0x0;
          if(MEMORY.ref(2, r1 + 0x8).getUnsigned() == 0x56 && MEMORY.ref(2, r1 + 0xa).getUnsigned() == 0x53 && MEMORY.ref(2, r1 + 0xc).getUnsigned() == 0x53 && MEMORY.ref(2, r1 + 0xe).getUnsigned() == 0x54) {
            break;
          }

          //LAB_802723c
          if(MEMORY.ref(2, r1 + 0x8).getUnsigned() == 0x45 && MEMORY.ref(2, r1 + 0xa).getUnsigned() == 0x44 && MEMORY.ref(2, r1 + 0xc).getUnsigned() == 0x56 && MEMORY.ref(2, r1 + 0xe).getUnsigned() == 0x53) {
            break;
          }

          //LAB_8027254
          if(MEMORY.ref(2, r1).getUnsigned() != 0x45 || MEMORY.ref(2, r1 + 0x2).getUnsigned() != 0x58 || MEMORY.ref(2, r1 + 0x4).getUnsigned() != 0x45 || MEMORY.ref(2, r1 + 0x6).getUnsigned() != 0x43) {
            //LAB_802726c
            MEMORY.ref(4, CPU.sp().value + 0x50).setu(-1);
            r3 = MEMORY.ref(4, sp24).get();
            MEMORY.ref(4, r3 + 0x50).setu(0);
            break;
          }
        } else {
          r5 = r5 + 0x1;
          if(r5 > 0x18) {
            MEMORY.ref(4, CPU.sp().value + 0x50).setu(-1);
            r3 = MEMORY.ref(4, sp24).get();
            MEMORY.ref(4, r3 + 0x50).setu(0);
            break;
          }
        }

        //LAB_8027274
        sleep(1);
      } while(true);
    }

    //LAB_802729e
    setTickCallback(getRunnable(GoldenSun_802.class, "FUN_8026e80"), 0xc80);

    jmp_80272a8:
    do {
      CPU.r9().value = CPU.sp().value + 0x64;
      FUN_80270ac();
      r0_0 = MEMORY.ref(4, sp24).get();
      MEMORY.ref(1, r0_0 + 0x26).setu(0);
      MEMORY.ref(4, r0_0 + 0xe0).setu(-1);
      MEMORY.ref(4, r0_0 + 0xd8).setu(0);

      if(readFlag_(0x16e) != 0) {
        r2 = MEMORY.ref(4, sp24).get();
        MEMORY.ref(4, r2 + 0xd8).setu(1);
        MEMORY.ref(4, r2 + 0xdc).setu(60);
      }

      //LAB_80272ea
      if(MEMORY.ref(4, CPU.sp().value + 0x50).get() > 0) {
        r6 = FUN_8021e6c(0);
      } else {
        //LAB_80272fa
        r6 = 0xe;
      }

      //LAB_80272fc
      if(r6 == 0x7) {
        final int[] charIds = new int[6];
        if(debug_3001f54.get() == 0 || (heldButtonsLastFrame_3001ae8.get() & 0x8) == 0) {
          r0_0 = 1;
        } else {
          r0_0 = 2;
        }

        //LAB_8027320
        r5 = getUnitIds_(r0_0, charIds);
        sleep(1);
        FUN_8023178(charIds, r5, charIds[0]);
        continue jmp_80272a8;
      }

      //LAB_8027340
      if(r6 == 0x4) {
        if(FUN_8026fa8() != 0) {
          continue jmp_80272a8;
        }
        MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r0.getAddress());
        MEMORY.ref(4, CPU.sp().value + 0x50).setu(1);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
        r0.unitId_00.set(MEMORY.ref(2, r1).getUnsigned());
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r1 + 0x4).setu(0x7ffe);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r2 + 0x6).setu(0x63);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r3 + 0x8).setu(0);
        r0_0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r0_0 + 0xa).setu(0x100);
        break;
      }

      //LAB_8027376
      if(r6 != 0xe) {
        break;
      }

      //LAB_802737e
      playSound_(0x9a);

      MEMORY.ref(4, CPU.sp().value + 0x2c).setu(0);
      if(MEMORY.ref(4, CPU.sp().value + 0x50).get() <= 0) {
        break;
      }

      //LAB_8027392
      MEMORY.ref(4, CPU.sp().value + 0x1c).setu(0);
      MEMORY.ref(4, CPU.sp().value + 0x18).setu(0);
      MEMORY.ref(4, CPU.sp().value + 0x20).setu(0);
      MEMORY.ref(4, CPU.sp().value + 0x14).setu(CPU.sp().value + 0x60);

      jmp_802739e:
      do {
        if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() == 0) {
          FUN_80b5130(0, MEMORY.ref(4, sp24).get() + 0x54);
        } else {
          //LAB_80273cc
          r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r3 = MEMORY.ref(4, sp24).get();
          r3 = r1 + r3;
          r2 = r3 + 0x50;
          r1 = 0x3;

          //LAB_80273da
          do {
            MEMORY.ref(1, r2 + 0x4).setu(MEMORY.ref(1, r2).getUnsigned());
            r2 = r2 + 0x1;
            r1 = r1 - 0x1;
          } while(r1 >= 0);
        }

        //LAB_80273e6
        r3 = MEMORY.ref(4, CPU.sp().value + 0x18).get();
        r2 = r0.getAddress() + r3;
        MEMORY.ref(4, CPU.sp().value + 0x4c).setu(r2);
        r0_0 = MEMORY.ref(4, CPU.sp().value + 0x20).get();
        r1 = MEMORY.ref(4, CPU.sp().value + 0x54).get();
        r0_0 = MEMORY.ref(2, r0_0 + r1).getUnsigned();
        MEMORY.ref(4, CPU.sp().value + 0x40).setu(r0_0);
        MEMORY.ref(4, CPU.sp().value + 0x48).setu(getCharOrMonsterData_(r0_0).getAddress());
        r5 = MEMORY.ref(4, 0x3001f34).get();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x40).get();
        MEMORY.ref(4, r5 + 0xe0).setu(r2);
        MEMORY.ref(4, r5 + 0x40).setu(0);
        r5 = r5 + 0x18;
        MEMORY.ref(4, r5 + 0x4).setu(0x80000400);
        MEMORY.ref(4, r5 + 0x8).setu(0);
        r0_0 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
        MEMORY.ref(2, r5 + 0x8).and(~0x3ff).or(FUN_8021b80(MEMORY.ref(1, r0_0 + 0x128).getUnsigned(), MEMORY.ref(4, CPU.sp().value + 0x30).get()) & 0x3ff);
        r2 = MEMORY.ref(2, r5 + 0x6).getUnsigned();
        r3 = 0xfffffe00;
        r3 = r3 & r2;
        MEMORY.ref(2, r5 + 0x6).setu(r3);
        r2 = MEMORY.ref(1, r5 + 0x9).getUnsigned();
        r3 = 0x80;
        MEMORY.ref(1, r5 + 0x4).setu(r3);
        r3 = 0xf;
        r3 = r3 & r2;
        r2 = 0xe0;
        r3 = r3 | r2;
        MEMORY.ref(1, r5 + 0x9).setu(r3);
        r2 = MEMORY.ref(4, sp24).get();
        r2 = r2 + 0x26;
        MEMORY.ref(1, r2).setu(1);

        jmp_8027454:
        do {
          FUN_801e318();
          r5 = 0x3001f34;
          r1 = MEMORY.ref(4, r5).get();
          MEMORY.ref(1, r1 + 0x24).setu(0);
          r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
          r2 = r2 + 0xe4;
          MEMORY.ref(4, r1 + r2).setu(0x80000000);
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          MEMORY.ref(2, r2).setu(MEMORY.ref(2, CPU.sp().value + 0x40).getUnsigned());
          r2 = MEMORY.ref(4, CPU.sp().value + 0x14).get();
          MEMORY.ref(2, r2 + 0x2).setu(0xff);
          CPU.r8().value = 0;
          FUN_80b50e0(MEMORY.ref(4, CPU.sp().value + 0x14).get(), 1);
          FUN_802281c(MEMORY.ref(4, CPU.sp().value + 0x14).get());
          sleep(1);
          r6 = FUN_8021e6c(1);
          sleep(1);
          if(r6 == -2) {
            final int[] charIds = new int[6];
            final int charCount = getUnitIds_(0x1, charIds);
            r3 = MEMORY.ref(4, sp24).get();
            MEMORY.ref(1, r3 + 0x26).setu(CPU.r8().value);
            sleep(1);
            FUN_8023178(charIds, charCount, MEMORY.ref(4, CPU.sp().value + 0x40).get());
            r3 = MEMORY.ref(4, sp24).get();
            MEMORY.ref(1, r3 + 0x26).setu(1);
            continue jmp_802739e;
          }

          //LAB_8027506
          FUN_80b50e0(MEMORY.ref(4, CPU.sp().value + 0x14).get(), 0);

          if(r6 == -1) {
            r0_0 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
            if(r0_0 == 0) {
              break jmp_802739e;
            }

            //LAB_8027520
            r0_0 = r0_0 - 0x1;
            r1 = r0_0 << 2;
            r2 = r0_0 << 4;
            r3 = r0_0 << 1;
            MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r0_0);
            MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r1);
            MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2);
            MEMORY.ref(4, CPU.sp().value + 0x20).setu(r3);
            continue jmp_802739e;
          }

          //LAB_8027532
          r5 = MEMORY.ref(4, r5).get();
          if(MEMORY.ref(4, r5 + 0x4c).get() == 0) {
            r6 = 0x3;
          }

          //LAB_802753c
          MEMORY.ref(4, r5 + 0x8).setu(0);
          MEMORY.ref(4, r5 + 0x4).setu(0x80002400);
          MEMORY.ref(2, r5 + 0x8).and(~0x3ff).or(FUN_8021c64(MEMORY.ref(4, CPU.sp().value + 0x34).get(), r6) & 0x3ff);

          if(r6 == 0xf) {
            r3 = 0x80;
          } else {
            //LAB_802757c
            r3 = 0x60;
          }

          //LAB_8027584
          MEMORY.ref(2, r5 + 0x6).and(~0x1ff).or(r3);
          MEMORY.ref(1, r5 + 0x4).setu(0x88);
          r2 = MEMORY.ref(4, sp24).get();
          r2 = r2 + 0x24;
          MEMORY.ref(1, r2).setu(1);

          switch(r6) {
            case 0: // selecting "attack" from "fight" menu?
              //LAB_80275fc
              r11 = addPanel(11, 17, 11, 3, 0x6);
              FUN_801e7c0(0x1f, r11, 16, 0);
              r1 = MEMORY.ref(4, sp24).get();
              MEMORY.ref(2, r1 + 0x6).and(~0x1ff).or(0x40);
              playSound_(0x70);
              r6 = FUN_8026080(MEMORY.ref(4, CPU.sp().value + 0x40).get(), 1, 1, 0);
              FUN_8016418(r11, 1);

              if(r6 == -1) {
                continue jmp_8027454;
              }

              //LAB_8027650
              r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
              MEMORY.ref(4, CPU.sp().value + 0x3c).setu(0);
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r6);
              MEMORY.ref(2, r1 + 0xc).setu(1);
              break;

            case 1: // switch 80275b8
              //LAB_8027670
              playSound_(0x70);
              r3 = MEMORY.ref(4, 0x3001f34).get();
              MEMORY.ref(4, r3 + 0x34).setu(0);
              MEMORY.ref(4, r3 + 0x30).setu(0);
              MEMORY.ref(4, r3 + 0x38).setu(0);

              //LAB_8027682
              do {
                r1 = MEMORY.ref(4, sp24).get();
                CPU.r8().value = r1 + 0x96;
                MEMORY.ref(2, r1 + 0x6).and(~0x1ff).or(48);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r3 = MEMORY.ref(2, r2 + 0x58).getUnsigned();
                r5 = r3 & 0x3fff;
                CPU.r10().value = r1 + 0x74;
                r4 = 0x0;
                r1 = 0x0;
                if(r5 != 0) {
                  r7 = MEMORY.ref(4, CPU.sp().value + 0x48).get() + 0x58;
                  r6 = CPU.r8().value;
                  CPU.r9().value = 0x3fff;

                  //LAB_80276cc
                  do {
                    if((MEMORY.ref(1, getAbility_(r5) + 0x1).getUnsigned() & 0x80) != 0) {
                      MEMORY.ref(1, CPU.r10().value + r4).setu(r1);
                      MEMORY.ref(2, r6).setu(r5);
                      r4 = r4 + 0x1;
                      r6 = r6 + 0x2;
                    }

                    //LAB_80276ee
                    r1 = r1 + 0x1;
                    if(r1 == 0x20) {
                      break;
                    }
                    r7 = r7 + 0x4;
                    r5 = MEMORY.ref(2, r7).getUnsigned() & CPU.r9().value;
                  } while(r5 != 0);
                }

                //LAB_8027700
                MEMORY.ref(1, CPU.r10().value + r4).setu(0);
                MEMORY.ref(2, CPU.r8().value + r4 * 0x2).setu(0);
                r6 = FUN_802592c(MEMORY.ref(4, CPU.sp().value + 0x40).get(), CPU.r8().value, r4);
                if(r6 == -1) {
                  continue jmp_8027454;
                }

                //LAB_8027722
                r3 = MEMORY.ref(1, CPU.r10().value + r6).getUnsigned();
                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r3 = MEMORY.ref(2, r1 + 0x58 + r3 * 0x4).getUnsigned();
                r2 = r3 & 0x3fff;
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r2);
                r6 = getAbility_(r2);
                r3 = MEMORY.ref(1, r6 + 0x8).getUnsigned();
                r5 = MEMORY.ref(4, sp24).get();
                CPU.r8().value = r3;
                CPU.r10().value = allocateFirstFreeSpriteSlot(0x80);
                r3 = 0x3001e8c;
                r7 = MEMORY.ref(4, r3).get();
                r11 = addPanel(8, 17, 18, 3, 6);
                r0_0 = MEMORY.ref(4, sp24).get();
                MEMORY.ref(2, r0_0 + 0x6).and(~0x1ff).or(40);
                r5 = r5 + 0xc;
                MEMORY.ref(4, r5 + 0x4).setu(0x40000400);
                MEMORY.ref(4, r5 + 0x8).setu(0);
                MEMORY.ref(2, r5 + 0x6).and(~0x1ff).or(r11.x_0c.get() * 8 + 8 & 0x1ff);
                MEMORY.ref(1, r5 + 0x4).setu(r11.y_0e.get() * 8 + 4);
                MEMORY.ref(2, r5 + 0x8).and(~0x3ff).or(FUN_8021b30(MEMORY.ref(4, CPU.sp().value + 0x38).get(), CPU.r10().value) & 0x3ff);
                r2 = MEMORY.ref(4, sp24).get();
                r2 = r2 + 0x25;
                MEMORY.ref(1, r2).setu(1);
                MEMORY.ref(1, r7 + 0xea7).setu(5);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                if(MEMORY.ref(1, r6 + 0x9).getUnsigned() > MEMORY.ref(2, r1 + 0x3a).get()) {
                  FUN_801e71c(2);
                } else {
                  //LAB_8027808
                  r2 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                  if(MEMORY.ref(1, r2 + 0x13d).getUnsigned() != 0) {
                    FUN_801e71c(9);
                  }
                }

                //LAB_802781a
                r1 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                FUN_801e7c0(r1 + 0x333, r11, 16, 0);
                drawNumber(MEMORY.ref(1, r6 + 0x9).getUnsigned(), 2, r11, 104, 0);
                MEMORY.ref(1, r7 + 0xea7).setu(15);
                FUN_801e71c(0xf);
                FUN_8019000(r11, 0xf01f, 13, 0, 0);
                FUN_8019000(r11, 0xf01e, 12, 0, 0);
                r3 = MEMORY.ref(1, r6 + 0x2).getUnsigned();
                if(r3 != 0x4) {
                  FUN_8019000(r11, r3 + 0x5001, 15, 0, 0);
                }

                //LAB_802787c
                r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                MEMORY.ref(2, r2 + 0xc).setu(CPU.r8().value);
                playSound_(0x70);
                r3 = FUN_802706c(r6);
                r6 = FUN_8026080(MEMORY.ref(4, CPU.sp().value + 0x40).get(), MEMORY.ref(1, r6).getUnsigned(), CPU.r8().value, r3);
                r3 = MEMORY.ref(4, sp24).get();
                r3 = r3 + 0x25;
                MEMORY.ref(1, r3).setu(0);
                clearVramSlot(CPU.r10().value);
                FUN_8016418(r11, 1);
              } while(r6 == -1);

              //LAB_80278be
              MEMORY.ref(4, CPU.sp().value + 0x3c).setu(1);
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r6);
              break;

            case 16: // switch 80275b8
              //LAB_80278e4
              playSound_(0x70);
              r2 = MEMORY.ref(4, 0x3001f34).get();
              MEMORY.ref(4, r2 + 0x34).setu(0);
              MEMORY.ref(4, r2 + 0x30).setu(0);
              MEMORY.ref(4, r2 + 0x38).setu(0);

              //LAB_80278f6
              do {
                r1 = MEMORY.ref(4, sp24).get();
                r3 = 0xfffffe00;
                r2 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
                r3 = r3 & r2;
                r2 = 0x50;
                r3 = r3 | r2;
                MEMORY.ref(2, r1 + 0x6).setu(r3);
                FUN_802281c(MEMORY.ref(4, CPU.sp().value + 0x14).get());
                r1 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                r2 = MEMORY.ref(4, sp24).get() + r1 + 0x54;
                r6 = FUN_8024934(0, 0, r2);
                FUN_802281c(MEMORY.ref(4, CPU.sp().value + 0x14).get());
                if(r6 == -1) {
                  continue jmp_8027454;
                }

                //LAB_8027930
                MEMORY.ref(4, CPU.sp().value + 0x3c).setu(6);
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r6);
                sleep(1);
                CPU.r8().value = MEMORY.ref(4, sp24).get() + 0xc;
                CPU.r9().value = getSummon_(r6);
                CPU.r10().value = getAbility_(MEMORY.ref(2, CPU.r9().value).getUnsigned());
                r0_0 = allocateFirstFreeSpriteSlot(0x80);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x3c).get();
                MEMORY.ref(4, CPU.sp().value + 0x28).setu(r0_0);
                r11 = addPanel(10, 17, 17, 3, r1);
                r4 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                r3 = MEMORY.ref(4, sp24).get();
                r1 = CPU.r9().value + 0x4;
                r4 = r4 + 0x54;
                r2 = MEMORY.ref(1, r1).getUnsigned();
                r3 = MEMORY.ref(1, r3 + r4).getUnsigned();
                r7 = 0x0;
                if((r2 & 0xffff_ffffL) <= (r3 & 0xffff_ffffL)) {
                  r0_0 = r1;
                  r1 = r4;

                  //LAB_802799a
                  do {
                    r7 = r7 + 0x1;
                    r1 = r1 + 0x1;
                    if(r7 > 0x3) {
                      break;
                    }
                    r3 = MEMORY.ref(4, sp24).get();
                    r0_0 = r0_0 + 0x1;
                    r2 = MEMORY.ref(1, r0_0).getUnsigned();
                    r3 = MEMORY.ref(1, r3 + r1).getUnsigned();
                  } while((r2 & 0xffff_ffffL) <= (r3 & 0xffff_ffffL));
                }

                //LAB_80279ae
                r3 = r7 ^ 0x4;
                r2 = -r3 | r3;
                r4 = r2 >>> 31;
                r0_0 = MEMORY.ref(4, sp24).get();
                MEMORY.ref(2, r0_0 + 0x6).and(~0x1ff).or(56);
                MEMORY.ref(4, CPU.r8().value + 0x4).setu(0x40000400);
                r4 = 1 - r4;
                MEMORY.ref(4, CPU.r8().value + 0x8).setu(0);
                MEMORY.ref(2, CPU.r8().value + 0x6).and(~0x1ff).or(r11.x_0c.get() * 8 + 8 & 0x1ff);
                MEMORY.ref(1, CPU.r8().value + 0x4).setu(r11.y_0e.get() * 8 + 4);
                r3 = MEMORY.ref(2, CPU.r9().value).getUnsigned();
                MEMORY.ref(2, CPU.r8().value + 0x8).and(~0x3ff).or(FUN_8021b30(r3 & 0x3fff, MEMORY.ref(4, CPU.sp().value + 0x28).get()) & 0x3ff);
                r3 = MEMORY.ref(4, sp24).get();
                r3 = r3 + 0x25;
                MEMORY.ref(1, r3).setu(1);
                if(r4 == 0x0) {
                  FUN_801e71c(2);
                }

                //LAB_8027a42
                getSummon_(r6);
                FUN_801e7c0(MEMORY.ref(2, r6).getUnsigned() + 0x333, r11, 16, 0);
                r2 = 0x0;
                r3 = r2 << 1;
                r6 = CPU.r9().value;
                r5 = r3;
                r7 = 0x0;
                CPU.r8().value = r2;
                r6 = r6 + 0x4;
                r5 = r5 + 0xd;

                //LAB_8027a7e
                do {
                  if(MEMORY.ref(1, r6).getUnsigned() != 0) {
                    FUN_8019000(r11, r7 + 0x5001, r5, 0, CPU.r8().value);
                    FUN_8018efc(r11, MEMORY.ref(1, r6).getUnsigned() + 0x30, r5 + 1, 0, CPU.r8().value);
                    r5 = r5 + 0x2;
                  }

                  //LAB_8027aae
                  r7 = r7 + 0x1;
                  r6 = r6 + 0x1;
                } while(r7 < 4);

                if(r4 != 0) {
                  playSound_(0x70);
                } else {
                  //LAB_8027ac8
                  playSound_(0x72);
                }

                //LAB_8027ace
                r3 = FUN_802706c(CPU.r10().value);
                r1 = MEMORY.ref(1, CPU.r10().value).getUnsigned();
                r2 = MEMORY.ref(1, CPU.r10().value + 0x8).getUnsigned();
                r6 = FUN_8026080(MEMORY.ref(4, CPU.sp().value + 0x40).get(), r1, r2, r3);
                r3 = MEMORY.ref(1, CPU.r10().value + 0x8).getUnsigned();
                r0_0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                MEMORY.ref(2, r0_0 + 0xc).setu(r3);
                r3 = MEMORY.ref(4, sp24).get();
                r3 = r3 + 0x25;
                MEMORY.ref(1, r3).setu(0);
                clearVramSlot(MEMORY.ref(4, CPU.sp().value + 0x28).get());
                FUN_8016418(r11, 1);
              } while(r6 == -1);

              //LAB_8027b0e
              r2 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
              CPU.lr().value = 0;
              r2 = r2 + 0x54;
              r1 = MEMORY.ref(4, sp24).get();
              r0_0 = CPU.r9().value + 0x4;
              r5 = r2;
              CPU.r12().value = sp24;
              r4 = MEMORY.ref(1, r0_0).getUnsigned();
              r3 = MEMORY.ref(1, r1 + r5).getUnsigned();
              r7 = 0x0;

              do {
                if((r4 & 0xffff_ffffL) > (r3 & 0xffff_ffffL)) {
                  MEMORY.ref(1, r1 + r5).setu(CPU.lr().value);
                  break;
                }

                //LAB_8027b38
                r3 = r3 - r4;
                r7 = r7 + 0x1;
                MEMORY.ref(1, r1 + r5).setu(r3);
                r0_0 = r0_0 + 0x1;
                r2 = r2 + 0x1;
                if(r7 > 0x3) {
                  break;
                }

                //LAB_8027b48
                r1 = MEMORY.ref(4, CPU.r12().value).get();
                r5 = r2;
                r4 = MEMORY.ref(1, r0_0).getUnsigned();
                r3 = MEMORY.ref(1, r1 + r5).getUnsigned();
              } while(true);

              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r6);
              break;

            case 15: // switch 80275b8
              //LAB_8027b5c
              playSound_(0x70);
              r2 = MEMORY.ref(4, 0x3001f34).get();
              MEMORY.ref(4, r2 + 0x34).setu(0);
              MEMORY.ref(4, r2 + 0x30).setu(0);
              MEMORY.ref(4, r2 + 0x38).setu(0);

              //LAB_8027b6e
              do {
                r1 = MEMORY.ref(4, sp24).get();
                CPU.r10().value = ~0x1ff;
                r3 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
                r2 = CPU.r10().value;
                r2 = r2 & r3;
                r3 = 0x90;
                r2 = r2 | r3;
                MEMORY.ref(2, r1 + 0x6).setu(r2);
                r7 = 0x3001f34;
                r5 = MEMORY.ref(4, CPU.sp().value + 0x1c).get();
                r2 = MEMORY.ref(4, r7).get();
                r5 = r5 + 0xe4;
                MEMORY.ref(4, r2 + r5).setu(0x80000000);
                r6 = FUN_8023e70(MEMORY.ref(4, CPU.sp().value + 0x40).get());
                CPU.r8().value = 0;
                r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                CPU.r9().value = -1;
                MEMORY.ref(2, r3 + 0xc).setu(CPU.r8().value);
                if(r6 == CPU.r9().value) {
                  continue jmp_8027454;
                }

                //LAB_8027bb2
                MEMORY.ref(4, CPU.sp().value + 0x3c).setu(5);
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r6);
                r3 = MEMORY.ref(4, r7).get();
                MEMORY.ref(4, r3 + r5).setu(r6);
                r2 = MEMORY.ref(4, CPU.sp().value + 0x38).get();
                r7 = r2 >> 8;
                r4 = r2 & 0xff;
                r7 = r7 & 0xf;
                if(FUN_8077208(MEMORY.ref(4, CPU.sp().value + 0x40).get(), r7, r4) == 0) {
                  //LAB_8027cd4
                  r11 = addPanel(11, 17, 10, 3, 6);
                  r1 = MEMORY.ref(4, sp24).get();
                  r2 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
                  r3 = CPU.r10().value;
                  r3 = r3 & r2;
                  r2 = 0x40;
                  r3 = r3 | r2;
                  MEMORY.ref(2, r1 + 0x6).setu(r3);
                  FUN_801e71c(2);
                  FUN_8019000(r11, r7 + 0x5001, 0, 0, 0);
                  FUN_801e7c0(r4 + r7 * 0x14 + 0x45f, r11, 16, 0);
                  FUN_801e71c(15);
                  r0_0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                  MEMORY.ref(2, r0_0 + 0xc).setu(1);
                  sleep(1);
                  playSound_(0x70);
                  r6 = FUN_8026080(MEMORY.ref(4, CPU.sp().value + 0x40).get(), 4, 0, 7);
                  FUN_8016418(r11, 1);
                  if(r6 != CPU.r9().value) {
                    break;
                  }
                } else {
                  r5 = getAbility_(FUN_80771e8(r7, r4));
                  r6 = MEMORY.ref(1, r5 + 0x8).getUnsigned();
                  r11 = addPanel(11, 17, 10, 3, 6);
                  r1 = MEMORY.ref(4, sp24).get();
                  r2 = MEMORY.ref(2, r1 + 0x6).getUnsigned();
                  r3 = CPU.r10().value;
                  r3 = r3 & r2;
                  r2 = 0x40;
                  r3 = r3 | r2;
                  MEMORY.ref(2, r1 + 0x6).setu(r3);
                  FUN_8019000(r11, r7 + 0x5001, CPU.r8().value, 0, CPU.r8().value);
                  FUN_801e7c0(r4 + r7 * 0x14 + 0x45f, r11, 16, 0);
                  r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                  MEMORY.ref(2, r3 + 0xc).setu(r6);
                  sleep(1);
                  playSound_(0x70);
                  r3 = FUN_802706c(r5);
                  r6 = FUN_8026080(MEMORY.ref(4, CPU.sp().value + 0x40).get(), MEMORY.ref(1, r5).getUnsigned(), r6, r3);
                  r3 = MEMORY.ref(4, sp24).get();
                  r3 = r3 + 0xd8;
                  r3 = MEMORY.ref(4, r3).get();
                  if(r3 != 0) {
                    final Panel24 panel = FUN_8021e48(0xc4e, 0xf, 0x8);

                    //LAB_8027c98
                    while(FUN_8017364() == 0) {
                      //LAB_8027c92
                      sleep(1);
                    }

                    FUN_8016418(panel, 1);
                    r1 = MEMORY.ref(4, sp24).get();
                    MEMORY.ref(4, r1 + 0xd8).incr();
                    MEMORY.ref(4, r1 + 0xdc).setu(0x2d);
                  }

                  //LAB_8027cbc
                  FUN_8016418(r11, 1);
                  if(r6 != -1) {
                    break;
                  }
                }
              } while(true);

              //LAB_8027cce
              //LAB_8027d68
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r6);
              break;

            case 2: // switch 80275b8
              //LAB_8027d6a
              playSound_(0x70);
              r3 = MEMORY.ref(4, 0x3001f34).get();
              MEMORY.ref(4, r3 + 0x34).setu(0);
              MEMORY.ref(4, r3 + 0x30).setu(0);
              MEMORY.ref(4, r3 + 0x38).setu(0);

              //LAB_8027d7c
              do {
                r1 = MEMORY.ref(4, sp24).get();
                MEMORY.ref(2, r1 + 0x6).and(~0x1ff).or(96);
                CPU.r10().value = r1 + 0x96;
                CPU.r9().value = r1 + 0x74;
                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r5 = MEMORY.ref(2, r1 + 0xd8).getUnsigned();
                CPU.r8().value = 0;
                r4 = 0x0;
                if(r5 != 0) {
                  r3 = r1 + 0xd8;
                  r7 = CPU.r9().value;
                  r6 = CPU.r10().value;

                  //LAB_8027dbc
                  do {
                    r0_0 = FUN_8025180(MEMORY.ref(4, CPU.sp().value + 0x40).get(), r5);
                    if(r0_0 == 0) {
                      r2 = 0x1;
                      MEMORY.ref(2, r6).setu(r5);
                      CPU.r8().value = CPU.r8().value + r2;
                      MEMORY.ref(1, r7).setu(r4);
                      r6 = r6 + 0x2;
                      r7 = r7 + 0x1;
                    }

                    //LAB_8027de2
                    r4 = r4 + 0x1;
                    if(r4 == 0xf) {
                      break;
                    }
                    r3 = r3 + 0x2;
                    r5 = MEMORY.ref(2, r3).getUnsigned();
                  } while(r5 != 0);
                }

                //LAB_8027df0
                r0_0 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r5 = MEMORY.ref(2, r0_0 + 0xd8).getUnsigned();
                r4 = 0x0;
                if(r5 != 0) {
                  r1 = CPU.r8().value;
                  r2 = r0_0;
                  r7 = CPU.r8().value;
                  r3 = r1 << 1;
                  r0_0 = CPU.r10().value;
                  r2 = r2 + 0xd8;
                  r7 = r7 + CPU.r9().value;
                  r6 = r3 + r0_0;

                  //LAB_8027e0c
                  do {
                    if(FUN_8025180(MEMORY.ref(4, CPU.sp().value + 0x40).get(), r5) != 0) {
                      MEMORY.ref(2, r6).setu(r5);
                      MEMORY.ref(1, r7).setu(r4);
                      CPU.r8().value++;
                      r6 = r6 + 0x2;
                      r7 = r7 + 0x1;
                    }

                    //LAB_8027e32
                    r4 = r4 + 0x1;
                    if(r4 == 0xf) {
                      break;
                    }
                    r2 = r2 + 0x2;
                    r5 = MEMORY.ref(2, r2).getUnsigned();
                  } while(r5 != 0);
                }

                //LAB_8027e40
                MEMORY.ref(2, CPU.r10().value + CPU.r8().value * 0x2).setu(0);
                r6 = FUN_8025200(MEMORY.ref(4, CPU.sp().value + 0x40).get(), CPU.r10().value, CPU.r8().value);
                if(r6 == -1) {
                  continue jmp_8027454;
                }

                //LAB_8027e60
                r6 = MEMORY.ref(1, CPU.r9().value + r6).getUnsigned();
                r3 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                MEMORY.ref(4, CPU.sp().value + 0x38).setu(r6);
                r6 = 0xd8 + r6 * 0x2;
                CPU.r8().value = getAbility_(getItem_(MEMORY.ref(2, r3 + r6).getUnsigned()).useAbility_28.get());
                CPU.r10().value = MEMORY.ref(1, CPU.r8().value + 0x8).getUnsigned();
                r5 = MEMORY.ref(4, sp24).get();
                CPU.r9().value = allocateFirstFreeSpriteSlot(0x80);
                r11 = addPanel(9, 17, 15, 3, 6);
                r0_0 = MEMORY.ref(4, sp24).get();
                MEMORY.ref(2, r0_0 + 0x6).and(~0x1ff).or(48);
                r5 = r5 + 0xc;
                MEMORY.ref(4, r5 + 0x4).setu(0x40000400);
                MEMORY.ref(4, r5 + 0x8).setu(0);
                MEMORY.ref(1, r5 + 0x4).setu(r11.y_0e.get() * 8 + 4);
                MEMORY.ref(2, r5 + 0x6).and(~0x1ff).or(r11.x_0c.get() * 8 + 8 & 0x1ff);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                MEMORY.ref(2, r5 + 0x8).and(~0x3ff).or(FUN_8021af0(MEMORY.ref(2, r1 + r6).getUnsigned(), CPU.r9().value) & 0x3ff);
                r2 = MEMORY.ref(4, sp24).get();
                r2 = r2 + 0x25;
                MEMORY.ref(1, r2).setu(1);
                r1 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
                r0_0 = MEMORY.ref(2, r1 + r6).getUnsigned() & 0x1ff;
                r0_0 = r0_0 + 0x182;
                FUN_801e7c0(r0_0, r11, 24, 0);
                r3 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
                MEMORY.ref(2, r3 + 0xc).setu(CPU.r10().value);
                playSound_(0x70);
                r3 = FUN_802706c(CPU.r8().value);
                r6 = FUN_8026080(MEMORY.ref(4, CPU.sp().value + 0x40).get(), MEMORY.ref(1, CPU.r8().value).getUnsigned(), CPU.r10().value, r3);
                r3 = MEMORY.ref(4, sp24).get();
                r3 = r3 + 0x25;
                MEMORY.ref(1, r3).setu(0);
                clearVramSlot(CPU.r9().value);
                FUN_8016418(r11, 1);
              } while(r6 == -1);

              //LAB_8027f78
              MEMORY.ref(4, CPU.sp().value + 0x3c).setu(2);
              MEMORY.ref(4, CPU.sp().value + 0x44).setu(r6);
              break;

            case 3: // switch 80275b8
              //LAB_8027f7e
              MEMORY.ref(4, CPU.sp().value + 0x3c).setu(3);
              break;
          }

          break;
        } while(true);

        //LAB_8027f82
        playSound_(0x6e);
        r1 = MEMORY.ref(2, CPU.sp().value + 0x40).getUnsigned();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r2).setu(r1);
        r5 = MEMORY.ref(4, CPU.sp().value + 0x48).get();
        r5 = r5 + 0x40;
        r6 = MEMORY.ref(2, r5).getUnsigned();
        if(r6 != 0) {
          r6 = r6 + (MEMORY.ref(2, r5).getUnsigned() * rand() >>> 20);
        }

        //LAB_8027fa6
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r2 + 0x4).setu(r6);
        if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() != 0) {
          r3 = MEMORY.ref(4, CPU.sp().value + 0x20).get() + MEMORY.ref(4, CPU.sp().value + 0x54).get();
          if(MEMORY.ref(2, r3).getUnsigned() == MEMORY.ref(2, r3 - 0x2).getUnsigned()) {
            r2 = r6 << 16;
            r3 = r2 >> 16;
            r2 = r2 >>> 31;
            r3 = r3 + r2;
            r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
            r3 = r3 >> 1;
            MEMORY.ref(2, r2 + 0x4).setu(r3);
          }
        }

        //LAB_8027fce
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        if(MEMORY.ref(2, r1 + 0x4).get() < 0) {
          MEMORY.ref(2, r1 + 0x4).setu(2000);
        }

        //LAB_8027fe0
        r3 = MEMORY.ref(2, CPU.sp().value + 0x3c).getUnsigned();
        r0_0 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r0_0 + 0x6).setu(r3);
        r1 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r1 + 0x8).setu(MEMORY.ref(2, CPU.sp().value + 0x38).getUnsigned());
        r1 = CPU.sp().value + 0x44;
        r1 = MEMORY.ref(2, r1).getUnsigned();
        r2 = MEMORY.ref(4, CPU.sp().value + 0x4c).get();
        MEMORY.ref(2, r2 + 0xa).setu(r1);
        r2 = MEMORY.ref(4, CPU.sp().value + 0x2c).get();
        r2 = r2 + 0x1;
        r3 = r2 << 2;
        MEMORY.ref(4, CPU.sp().value + 0x1c).setu(r3);
        r3 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
        MEMORY.ref(4, CPU.sp().value + 0x2c).setu(r2);
        MEMORY.ref(4, CPU.sp().value + 0x18).setu(r2 << 4);
        MEMORY.ref(4, CPU.sp().value + 0x20).setu(r2 << 1);

        if(r2 >= r3) {
          break;
        }
      } while(true);

      //LAB_8028014
      if(MEMORY.ref(4, CPU.sp().value + 0x2c).get() >= MEMORY.ref(4, CPU.sp().value + 0x50).get()) {
        break;
      }
    } while(true);

    //LAB_8028020
    r0_0 = MEMORY.ref(4, sp24).get();
    if(MEMORY.ref(4, r0_0 + 0x50).get() != 0) {
      r2 = 0x2002224;
      MEMORY.ref(2, r2 + 0x8).setu(0x45);
      MEMORY.ref(2, r2 + 0xa).setu(0x44);
      MEMORY.ref(2, r2 + 0xc).setu(0x56);
      MEMORY.ref(2, r2 + 0xe).setu(0x53);
    }

    //LAB_802803c
    r0_0 = MEMORY.ref(4, r0_0 + 0x44).get();
    if(r0_0 != 0) {
      FUN_8016418(MEMORY.ref(4, r0_0, Panel24::new), 1);
    }

    //LAB_8028048
    clearVramSlot(MEMORY.ref(4, CPU.sp().value + 0x30).get());
    clearVramSlot(MEMORY.ref(4, CPU.sp().value + 0x34).get());
    clearTickCallback(getRunnable(GoldenSun_802.class, "FUN_8026e80"));
    r2 = MEMORY.ref(4, sp24).get();
    if(MEMORY.ref(4, r2 + 0x50).get() != 0) {
      r6 = 0x0;
      if(MEMORY.ref(4, r2 + 0x44).get() != 0) {
        //LAB_80280b8
        r2 = MEMORY.ref(4, sp24).get();
        MEMORY.ref(4, r2 + 0x44).setu(0);
      } else if(struct._52.get() == 0) {
        MEMORY.ref(4, sp24 + 0x44).setu(addPanel(0, 16, 30, 4, 42).getAddress());
        r3 = MEMORY.ref(4, sp24).get();
        FUN_8016738();
        CPU.r9().value = CPU.sp().value + 0x64;
        FUN_80270d8();
      } else {
        //LAB_80280bc
        r2 = MEMORY.ref(4, sp24).get();
        MEMORY.ref(4, r2 + 0x44).setu(0);
      }

      //LAB_80280c4
      do {
        r2 = struct._50.get();
        r3 = r2 ^ 0x1;
        r2 = r3 << 1;
        r2 = r2 + r3;
        r3 = 0x2002024;
        r2 = r2 << 3;
        r1 = r2 + r3;
        if(struct._52.get() != 0) {
          MEMORY.ref(4, CPU.sp().value + 0x50).setu(-1);
          break;
        }

        //LAB_80280e4
        if((_3001f64.get() & 0x3) == 0x3) {
          //LAB_80280fe
          r2 = MEMORY.ref(2, r1 + 0x8).getUnsigned();
          r6 = 0x0;
          if(r2 == 0x45 && MEMORY.ref(2, r1 + 0xa).getUnsigned() == 0x44 && MEMORY.ref(2, r1 + 0xc).getUnsigned() == 0x56 && MEMORY.ref(2, r1 + 0xe).getUnsigned() == 0x53) {
            break;
          }

          //LAB_802811a
          if(r2 != 0x56 || MEMORY.ref(2, r1 + 0xa).getUnsigned() != 0x53 || MEMORY.ref(2, r1 + 0xc).getUnsigned() != 0x53 || MEMORY.ref(2, r1 + 0xe).getUnsigned() != 0x54) {
            //LAB_8028132
            r6 = 0x1;
          }
        } else {
          r6 = r6 + 0x1;
          if(r6 > 0x18) {
            MEMORY.ref(4, CPU.sp().value + 0x50).setu(-1);
            break;
          }
        }

        //LAB_8028134
        sleep(1);
      } while(true);

      //LAB_8028156
      r3 = MEMORY.ref(4, sp24).get();
      r0_0 = MEMORY.ref(4, r3 + 0x44).get();
      if(r0_0 != 0) {
        FUN_8016418(MEMORY.ref(4, r0_0, Panel24::new), 1);
      }
    }

    //LAB_8028166
    FUN_80b50d0(0);
    freeSlot(57);
    r0_0 = MEMORY.ref(4, CPU.sp().value + 0x50).get();
    CPU.sp().value += 0x64;
    CPU.r8().value = CPU.pop();
    CPU.r9().value = CPU.pop();
    CPU.r10().value = CPU.pop();
    return r0_0;
  }

  @Method(0x8028194)
  public static void drawChoiceMenu() {
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;

    CPU.sp().value -= 0xc;

    final ChoiceMenu98 menu = boardWramMallocHead_3001e50.offset(58 * 0x4).deref(4).cast(ChoiceMenu98::new);

    final int scaleVal = (MEMORY.ref(2, 0x80366f8 + (_3001e40.get() * 0x2 & 0x1f) * 0x2).getUnsigned() - 0x100) / 4 + 0x130;
    MEMORY.ref(2, CPU.sp().value + 0x4).setu(scaleVal & 0xffff);
    MEMORY.ref(2, CPU.sp().value + 0x6).setu(scaleVal & 0xffff);
    MEMORY.ref(2, CPU.sp().value + 0x8).setu(0);
    final int rotScaleIndex = addRotScaleParams(CPU.sp().value + 0x4);

    //LAB_8028202
    for(int optionIndex = 0; optionIndex < menu.count_8e.get(); optionIndex++) {
      final ChoiceMenu98.Option14 option = menu.options_00.get(optionIndex);

      if(option.x_0c.get() != 0) {
        if(optionIndex == menu.selectedOption_8c.get()) {
          final int modifiedX = option.x_0c.get() + scaleVal * 7 / 0x200 - 0x14;
          final int modifiedY;

          if(option.y_0e.get() != 0) {
            modifiedY = option.y_0e.get() + scaleVal * 3 / 0x100 - 0x14;
          } else {
            //LAB_8028246
            modifiedY = scaleVal * 15 / 0x100 - 0x1e & 0xff;
          }

          //LAB_802825a
          option.packet_00.next_00.clear();
          option.packet_00.attribs_04.y_00.set(modifiedY);
          option.packet_00.attribs_04.flags_01.set(0x23); // 256 colours, rotation/scaling enabled, double-size
          option.packet_00.attribs_04.attrib1_02.set(0x8000 | rotScaleIndex << 9 | modifiedX);
          option.packet_00.attribs_04.attrib2_04.set(vramSlots_3001b10.get(option.vramSlot_12.get()).vramAddr_02.get() >>> 5);
          r1 = 0xf6;
        } else {
          //LAB_8028282
          option.packet_00.next_00.clear();
          option.packet_00.attribs_04.y_00.set(option.y_0e.get());
          option.packet_00.attribs_04.flags_01.set(0x20); // 256 colours
          option.packet_00.attribs_04.attrib1_02.set(0x8000 | option.x_0c.get());
          option.packet_00.attribs_04.attrib2_04.set(vramSlots_3001b10.get(option.vramSlot_12.get()).vramAddr_02.get() >>> 5);
          r1 = 0xf5;
        }

        //LAB_80282a4
        insertIntoRenderQueue(option.packet_00, r1);
      }

      //LAB_80282ae
    }

    final int lr;

    //LAB_80282bc
    r1 = boardWramMallocHead_3001e50.offset(31 * 0x4).get();
    if(menu.y_94.get() != 0) {
      //LAB_80283ae
      if(r1 != 0) {
        if(menu.count_8e.get() != 0) {
          r2 = MEMORY.ref(1, r1 + 0x539).getUnsigned();
          lr = r1 + r2 * 0x284;
          r0 = menu.options_00.get(menu.selectedOption_8c.get()).x_0c.get();
          r2 = menu.selectedOption_8c.get() * 0x50;
          r3 = r2 - 0xb01;
          if(r3 < 0) {
            r3 = r2 - 0xa02;
          }

          //LAB_80283fe
          r3 = r3 >> 8;
          r0 = (r0 - r3) * 0x100 + r0 + r3 + 0x17;
          r2 = menu.options_00.get(menu.selectedOption_8c.get()).y_0e.get();
          r1 = scaleVal * 0x20;
          r3 = r1 - 0x1f01;
          if(r3 < 0) {
            r3 = r1 - 0x1d02;
          }

          //LAB_8028422
          r3 = r3 >> 9;
          r2 = r2 - r3 - 1;
          r1 = lr + r2 * 0x4 + 0x6;

          //LAB_8028436
          for(int i = r2; i < 0x88; i++) {
            MEMORY.ref(2, r1).and(0xff).oru(r0);
            r1 += 0x4;
          }

          //LAB_8028448
          r0 = menu.options_00.get(0).x_0c.get();
          if(menu.selectedOption_8c.get() == 0) {
            r1 = scaleVal * 0x10;
            r3 = r1 - 0xb01;
            if(r3 < 0) {
              r3 = r1 - 0xa02;
            }

            //LAB_8028468
            r3 = r3 >> 8;
            r0 = r0 - r3;
          }

          //LAB_802846c
          r1 = lr + 0x226;

          //LAB_8028476
          for(int i = 0x88; i < 0xa0; i++) {
            MEMORY.ref(2, r1).and(0xff).oru(r0 << 8);
            r1 += 0x4;
          }
        }
      }
    } else {
      if(r1 != 0) {
        //LAB_80282d2
        if(menu.count_8e.get() != 0) {
          //LAB_80282de
          final int r10_0 = r1 + MEMORY.ref(1, r1 + 0x539).getUnsigned() * 0x284;
          r0 = menu.options_00.get(menu.selectedOption_8c.get()).x_0c.get();
          r3 = scaleVal * 0xc;
          r2 = r3 - 0xb01;
          if(r2 < 0) {
            r2 = r3 - 0xa02;
          }

          //LAB_802831e
          r2 = CPU.asrT(r2, 8);
          r3 = CPU.subT(r0, r2);
          r3 = CPU.lslT(r3, 8);
          r2 = CPU.addT(r0, r2);
          r3 = CPU.addT(r3, r2);
          r0 = CPU.addT(r3, 0x0);
          r3 = menu.options_00.get(menu.selectedOption_8c.get()).y_0e.get();
          r2 = CPU.lslT(scaleVal, 5);
          r4 = CPU.addT(r3, 0x0);
          r3 = r2 - 0x1f01;
          r0 = CPU.addT(r0, 0x17);
          r4 = CPU.addT(r4, 0x18);
          if(r3 < 0) {
            r3 = r2 - 0x1d02;
          }

          //LAB_8028346
          r3 = CPU.asrT(r3, 9);
          r3 = CPU.addT(r4, r3);
          r4 = CPU.addT(r3, 0x1);
          r1 = r10_0 + 0x66;

          //LAB_8028358
          for(int i = 0x18; i < r4; i++) {
            MEMORY.ref(2, r1).and(0xff).oru(r0);
            r1 += 0x4;
          }

          //LAB_802836a
          r0 = menu.options_00.get(0).x_0c.get();
          if(menu.selectedOption_8c.get() == 0) {
            r1 = scaleVal * 0xc;
            r3 = r1 - 0xb01;
            if(r3 < 0) {
              r3 = r1 - 0xa02;
            }

            //LAB_802838c
            r3 = r3 >> 8;
            r0 = r0 - r3;
          }

          //LAB_8028390
          r1 = r10_0 + 0x6;

          //LAB_802839a
          for(int i = 0; i < 0x18; i++) {
            MEMORY.ref(2, r1).and(0xff).oru(r0 << 8);
            r1 += 0x4;
          }
        }
      }
    }

    //LAB_8028488
    CPU.sp().value += 0xc;
  }

  @Method(0x80284dc)
  public static ChoiceMenu98 allocateChoiceMenu() {
    final ChoiceMenu98 r5 = MEMORY.ref(4, mallocSlotBoard(58, 0x98), ChoiceMenu98::new);

    CPU.sp().value -= 0x4;
    MEMORY.ref(4, CPU.sp().value).setu(0);
    DMA.channels[3].SAD.setu(CPU.sp().value);
    DMA.channels[3].DAD.setu(r5.getAddress());
    DMA.channels[3].CNT.setu(0x85000026);
    CPU.sp().value += 0x4;

    setTickCallback(getRunnable(GoldenSun_802.class, "drawChoiceMenu"), 0xc76);
    return r5;
  }

  @Method(0x802851c)
  public static void deallocateChoiceMenu() {
    final ChoiceMenu98 r5 = boardWramMallocHead_3001e50.offset(58 * 0x4).deref(4).cast(ChoiceMenu98::new);
    clearTickCallback(getRunnable(GoldenSun_802.class, "drawChoiceMenu"));

    if(!r5.panel_78.isNull()) {
      FUN_8016418(r5.panel_78.deref(), 0x2);
    }

    //LAB_8028534
    //LAB_8028546
    for(int r6 = 0; r6 < r5.count_8e.get(); r6++) {
      clearVramSlot(r5.options_00.get(r6).vramSlot_12.get());
    }

    //LAB_8028558
    freeSlot(58);
    sleep(0x1);
  }

  /** Handles yes/no dialogue selection */
  @Method(0x8028574)
  public static int handleChoiceMenu(final int defaultOption) {
    final ChoiceMenu98 menu = boardWramMallocHead_3001e50.offset(58 * 0x4).deref(4).cast(ChoiceMenu98::new);
    menu.selectedOption_8c.set(defaultOption);

    //LAB_8028598
    jmp_8028672:
    do {
      FUN_8016478(menu.panel_78.deref());

      final int textId;
      if(menu.textIdGroup_92.get() != 0) {
        textId = menu.textIdGroup_92.get() + menu.selectedOption_8c.get();
      } else {
        //LAB_80285c0
        textId = menu.icons_84.get(menu.selectedOption_8c.get()).get() + 31;
      }

      //LAB_80285d0
      FUN_801e7c0(textId, menu.panel_78.deref(), 0, 0);

      //LAB_80285e6
      do {
        sleep(1);

        if((pressedButtons_3001c94.get() & BUTTON_A) != 0) {
          break jmp_8028672;
        }

        if((pressedButtons_3001c94.get() & BUTTON_B) != 0 || (pressedButtons_3001c94.get() & 0x8) != 0) {
          //LAB_80285b4
          playSound_(0x71);
          return -1;
        }

        if((pressedButtons_3001b04.get() & BUTTON_LEFT) != 0 || (pressedButtons_3001b04.get() & BUTTON_UP) != 0) {
          //LAB_8028620
          playSound_(0x6f);

          menu.selectedOption_8c.decr();
          if(menu.selectedOption_8c.get() < 0) {
            menu.selectedOption_8c.set(menu.count_8e.get() - 1);
          }

          break;
        }

        //LAB_802863e
        if((pressedButtons_3001b04.get() & BUTTON_RIGHT) != 0 || (pressedButtons_3001b04.get() & BUTTON_DOWN) != 0) {
          //LAB_8028652
          playSound_(0x6f);

          menu.selectedOption_8c.incr();
          if(menu.selectedOption_8c.get() >= menu.count_8e.get()) {
            menu.selectedOption_8c.set(0);
          }

          break;
        }
      } while(true);
    } while(true);

    //LAB_8028672
    playSound_(0x70);

    //LAB_802867e
    return menu.selectedOption_8c.get();
  }

  @Method(0x802875c)
  public static void loadChoiceMenuIconIntoVram(final int slot, final int icon) {
    final int dest = mallocChip(0x400);
    final int iconData = getPointerTableEntry(241);
    FUN_80053e8(iconData + MEMORY.ref(2, iconData + icon * 0x2).getUnsigned(), dest);
    allocateSpriteSlot(slot, 0x400, dest);
    setMallocAddress(dest);
  }

  /**
   * <ul>
   *   <li>5 - yes</li>
   *   <li>6 - no</li>
   *   <li>21, 22, 23, 24, 29, 30 - title screen icons</li>
   * </ul>
   */
  @Method(0x80287a8)
  public static void addChoiceMenuOption(final int icon) {
    final ChoiceMenu98 menu = boardWramMallocHead_3001e50.offset(58 * 0x4).deref(4).cast(ChoiceMenu98::new);

    final int index = menu.count_8e.get();
    if(index < 6) {
      final int slot = getFreeVramSlot();
      loadChoiceMenuIconIntoVram(slot, icon);

      final ChoiceMenu98.Option14 option = menu.options_00.get(index);
      option.x_0c.set(32 + index * 24);
      option.y_0e.set(136);
      option.vramSlot_12.set(slot);

      menu.icons_84.get(index).set(icon);
      menu.count_8e.incr();
    }

    //LAB_80287f8
  }

  /** After adding options, call this to calculate the layout and allocate the text panel */
  @Method(0x8028808)
  public static void updateChoiceMenuLayout(final int y, final int w, final int textIdGroup) {
    final ChoiceMenu98 menu = boardWramMallocHead_3001e50.offset(58 * 0x4).deref(4).cast(ChoiceMenu98::new);
    menu.panelW_90.set(w + 2);
    menu.textIdGroup_92.set(textIdGroup);
    menu.y_94.set(y);
    int x = 15 - (menu.count_8e.get() * 3 + divideS(menu.panelW_90.get() * 2, 3)) / 2;

    //LAB_8028868
    for(int i = 0; i < menu.count_8e.get(); i++) {
      final ChoiceMenu98.Option14 option = menu.options_00.get(i);
      option.x_0c.set(x << 3);
      option.y_0e.set(y << 3);
      x += 3;
    }

    //LAB_802887e
    menu.panel_78.setNullable(addPanel(x, y, menu.panelW_90.get(), 3, 0x2));
  }

  @Method(0x80288a8)
  public static void FUN_80288a8(int x, final int y, final int w, final int textIdGroup) {
    final ChoiceMenu98 r5 = boardWramMallocHead_3001e50.offset(58 * 0x4).deref(4).cast(ChoiceMenu98::new);
    r5.panelW_90.set(w + 2);
    r5.textIdGroup_92.set(textIdGroup);
    r5.y_94.set(y);

    //LAB_80288e4
    for(int i = 0; i < r5.count_8e.get(); i++) {
      r5.options_00.get(i).x_0c.set(x * 8);
      r5.options_00.get(i).y_0e.set(y * 8);
      x += 3;
    }

    //LAB_80288fc
    r5.panel_78.set(addPanel(x, y, r5.panelW_90.get(), 3, 0x2));
  }

  @Method(0x8028920)
  public static int handleAMenu(final int r0) {
    int hasDjinn = 0;

    if(getDjinnCount_(-1) == 0) {
      hasDjinn = 1;
    }

    //LAB_8028934
    int r5 = Math.max(0, MEMORY.ref(1, 0x8037403 + r0 + hasDjinn * 0x6).get() - 1);

    allocateChoiceMenu();
    addChoiceMenuOption(0x1);

    if(hasDjinn == 0) {
      addChoiceMenuOption(0xf);
    }

    //LAB_802895c
    addChoiceMenuOption(0x2);
    addChoiceMenuOption(0x7);
    updateChoiceMenuLayout(0x11, 0x7, 0);
    r5 = handleChoiceMenu(r5);
    deallocateChoiceMenu();

    if(r5 >= 0) {
      r5 = MEMORY.ref(1, 0x80373f7 + r5 + hasDjinn * 0x6 + 0x1).get();
    }

    //LAB_802898a
    return r5;
  }

  @Method(0x80289e8)
  public static int handleTitleScreenChoiceMenu() {
    final int r0 = FUN_801f77c();
    if(r0 < 0) {
      return -1;
    }

    //LAB_80289fc
    if(r0 == 0) {
      return 0;
    }

    int r6 = 0;
    int initialChoice = 0;

    //LAB_8028a04
    if(r0 == 3) {
      r6 = 1;
      //LAB_8028a0c
    } else if(r0 == 0x67) {
      r6 = 2;
      //LAB_8028a14
    } else if(r0 > 0x64) {
      r6 = 3;
    } else {
      //LAB_8028a1c
      initialChoice = 1;
    }

    //LAB_8028a1e
    allocateChoiceMenu();

    if(r6 == 0 || r6 == 3) {
      //LAB_8028a2a
      addChoiceMenuOption(21);
    }

    //LAB_8028a30
    if(r6 == 0 || r6 == 1) {
      addChoiceMenuOption(22);
    }

    //LAB_8028a3a
    if(r6 == 0 || r6 == 3) {
      //LAB_8028a42
      addChoiceMenuOption(23);
    }

    //LAB_8028a48
    addChoiceMenuOption(24);

    if(MEMORY.ref(2, 0x200200c).get() != 0) {
      addChoiceMenuOption(29);
    }

    //LAB_8028a5e
    if(MEMORY.ref(2, 0x2002010).get() != 0) {
      addChoiceMenuOption(30);
    }

    //LAB_8028a6e
    updateChoiceMenuLayout(0x11, 0x7, 0);

    final int choice = handleChoiceMenu(initialChoice);
    deallocateChoiceMenu();

    if(choice < 0) {
      return -1;
    }

    //LAB_8028a94
    //LAB_8028a96
    return MEMORY.ref(1, 0x803740f + choice + r6 * 0x6).get();
  }

  @Method(0x8028df4)
  public static int FUN_8028df4(final int r0, final int r1, final int r2, final int r3) {
    int r5 = r2;
    int r6 = r3;
    int r8 = 0;

    allocateChoiceMenu();

    if(r5 == 0) {
      r5 = 0x3;
    }

    //LAB_8028e12
    if(r0 != 0) {
      r8 = 0x11;
    }

    //LAB_8028e1a
    addChoiceMenuOption(5); // yes
    addChoiceMenuOption(6); // no
    updateChoiceMenuLayout(r8, r5, r1);
    r6 = handleChoiceMenu(r6);
    deallocateChoiceMenu();

    if(r6 == -1) {
      r6 = 1;
    }

    //LAB_8028e46
    return r6;
  }

  @Method(0x8028e54)
  public static int FUN_8028e54(final int x, final int y, final int defaultOption) {
    allocateChoiceMenu();
    addChoiceMenuOption(5);
    addChoiceMenuOption(6);
    FUN_80288a8(x, y, 3, 36);
    int selectedOption = handleChoiceMenu(defaultOption);
    deallocateChoiceMenu();

    if(selectedOption == -1) {
      selectedOption = 1;
    }

    //LAB_8028e96
    return selectedOption;
  }

  @Method(0x8029504)
  public static int FUN_8029504() {
    //LAB_8029506
    do {
      int r5;
      do {
        r5 = FUN_801db70();
        if(r5 == -1) {
          return -1;
        }

        if(r5 != 0) {
          break;
        }

        final int r0 = FUN_80207c4();
        if(r0 != -1) {
          return r0;
        }
      } while(true);

      //LAB_8029524
      if(r5 == 1) {
        FUN_801776c(0xc2a, 0x1);
        MEMORY.ref(1, 0x3001cc8).setu(1);
        break;
      }

      //LAB_8029536
      if(r5 != 2) {
        break;
      }
    } while(FUN_801d4cc() == -1);

    //LAB_8029542
    //LAB_8029544
    return 0;
  }
}
